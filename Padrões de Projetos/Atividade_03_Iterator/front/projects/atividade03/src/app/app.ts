import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms';
import { Piloto, PilotoService } from './services/piloto.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  title = 'f1-data-app';
  selectedFile: File | null = null;
  fileName: string = '';
  selectedOption: string = '';
  message: string = '';
  pilotos: Piloto[] = [];
  sortColumn: string = 'nenhuma';
  sortDirection: 'asc' | 'desc' = 'asc';
  originalPilotos: Piloto[] = [];

  constructor(private pilotoService: PilotoService) {}

  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
      this.fileName = file.name;
      this.uploadFile();
    }
  }

  uploadFile(): void {
    if (this.selectedFile) {
      this.pilotoService.uploadArquivo(this.selectedFile).subscribe(
        response => {
          this.message = response.message;
          console.log('Upload bem-sucedido', response);
        },
        error => {
          this.message = 'Erro ao fazer upload do arquivo.';
          console.error('Erro no upload', error);
        }
      );
    }
  }

  lerDados(): void {
    if (!this.selectedOption) {
      this.message = 'Por favor, selecione uma opção antes de ler os dados.';
      return;
    }

    this.pilotoService.getPilotos(this.selectedOption).subscribe(
      (data: Piloto[]) => {
        this.pilotos = data;
        this.originalPilotos = [...data];
        this.message = `Dados da ${this.selectedOption} lidos com sucesso!`;
        this.sortColumn = 'nenhuma';
        this.sortDirection = 'asc'; // Reseta a direção para ascendente ao carregar novos dados
        console.log('Dados recebidos', data);
      },
      error => {
        this.message = `Erro ao ler os dados da ${this.selectedOption}.`;
        console.error('Erro na leitura', error);
      }
    );
  }

  toggleSortDirection(): void {
    this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    this.sortPilotos(); // Chama a ordenação novamente com a nova direção
  }

  sortPilotos(): void {
    if (this.sortColumn === 'nenhuma') {
      this.pilotos = [...this.originalPilotos];
      return;
    }

    this.pilotos.sort((a, b) => {
      const aValue = (a as any)[this.sortColumn];
      const bValue = (b as any)[this.sortColumn];
      
      let comparison = 0;

      if (typeof aValue === 'string' && typeof bValue === 'string') {
        comparison = aValue.localeCompare(bValue);
      } else {
        if (aValue < bValue) {
          comparison = -1;
        } else if (aValue > bValue) {
          comparison = 1;
        }
      }

      // Inverte a comparação se a direção for descendente
      return this.sortDirection === 'asc' ? comparison : comparison * -1;
    });
  }
}
