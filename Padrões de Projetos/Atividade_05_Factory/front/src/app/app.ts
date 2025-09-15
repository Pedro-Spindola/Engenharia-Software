import { Component, signal } from '@angular/core';
import { CafeService } from './cafe.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('Atividade_04_PP');
  // Listas de opções para a interface
  tiposCafe = ['ESPRESSO', 'LATTE', 'CAPPUCCINO', 'AMERICANO', 'FRAPPUCCINO'];
  adicionais = ['ACUCAR', 'LEITE', 'CANELA', 'CREME', 'BAUNILHA', 'CARAMELO'];

  // Variáveis para armazenar as seleções do usuário
  tipoSelecionado: string = 'ESPRESSO';
  adicionaisSelecionados: string[] = [];

  // Variável para armazenar o resultado do pedido
  pedidoResult: any;

  constructor(private cafeService: CafeService) { }

  ngOnInit(): void { }

  // Função para lidar com a seleção dos checkboxes
  onCheckboxChange(adicional: string, event: any) {
    if (event.target.checked) {
      this.adicionaisSelecionados.push(adicional);
    } else {
      this.adicionaisSelecionados = this.adicionaisSelecionados.filter(item => item !== adicional);
    }
  }

  // Função para processar o pedido
  processarPedido() {
    this.cafeService.processarPedido(this.tipoSelecionado, this.adicionaisSelecionados)
      .subscribe({
        next: (response) => {
          this.pedidoResult = response;
        },
        error: (error) => {
          console.error('Erro ao processar pedido:', error);
          this.pedidoResult = { descricao: 'Erro no pedido', custo: 0 };
          alert('Erro ao processar o pedido. Por favor, tente novamente.');
        }
      });
  }
}
