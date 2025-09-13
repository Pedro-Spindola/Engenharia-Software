import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms';
import { Aluno, AlunoService } from './aluno.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  alunos: Aluno[] = [];
  ordenacaoSelecionada = 'nome'; // Define a ordenação inicial

  constructor(private alunoService: AlunoService) { }

  ngOnInit(): void {
    // Carrega a lista de alunos quando o componente é inicializado
    this.carregarAlunos();
  }

  carregarAlunos(): void {
    switch (this.ordenacaoSelecionada) {
      case 'nome':
        this.alunoService.getAlunosOrdenadosPorNome().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'cursoEnfase':
        this.alunoService.getAlunosOrdenadosPorCursoEnfase().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'cursoNome':
        this.alunoService.getAlunosOrdenadosPorCursoNome().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'enfaseCurso':
        this.alunoService.getAlunosOrdenadosPorEnfaseCurso().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'enfaseNome':
        this.alunoService.getAlunosOrdenadosPorEnfaseNome().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'situacaoNome':
        this.alunoService.getAlunosOrdenadosPorSituacaoNome().subscribe(data => {
          this.alunos = data;
        });
        break;
      case 'sobrenome':
        this.alunoService.getAlunosOrdenadosPorSobrenome().subscribe(data => {
          this.alunos = data;
        });
        break;
      default:
        // Caso a ordenação não seja reconhecida, pode-se carregar uma padrão
        this.alunoService.getAlunosOrdenadosPorNome().subscribe(data => {
          this.alunos = data;
        });
        break;
    }
  }

  // Método chamado quando o usuário muda a opção do combobox
  onOrdenacaoChange(event: any): void {
    this.ordenacaoSelecionada = event.target.value;
    this.carregarAlunos();
  }
}
