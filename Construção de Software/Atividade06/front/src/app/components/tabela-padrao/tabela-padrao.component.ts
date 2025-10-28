import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Funcionario, FuncionarioService} from '../../services/funcionario.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-tabela-padrao',
  imports: [CommonModule, FormsModule],
  templateUrl: './tabela-padrao.component.html',
  styleUrl: './tabela-padrao.component.scss'
})

export class TabelaPadraoComponent implements OnInit {
  funcionarios: Funcionario[] = [];
  funcionariosFiltrados: Funcionario[] = [];
  filtroStatus: string = 'todos';
  listaCargos: String[] = [];

  constructor(private funcionarioService: FuncionarioService, private router: Router) {}

  ngOnInit(): void {
    this.funcionarioService.findAll().subscribe({
      next: (dados) => {
        this.funcionarios = dados;
        this.funcionariosFiltrados = [...dados];
        console.log(dados);
      },
      error: (erro) => {
        console.error('Erros ao buscar contatos: ', erro);
      }
    });
  }

  aplicarFiltroStatus(): void {
    if (this.filtroStatus === 'todos') {
      this.funcionariosFiltrados = [...this.funcionarios];
    } else if (this.filtroStatus === 'ativo') {
      this.funcionariosFiltrados = this.funcionarios.filter(f => f.status === true);
    } else if (this.filtroStatus === 'inativo') {
      this.funcionariosFiltrados = this.funcionarios.filter(f => f.status === false);
    }
  }

  EditarFuncionario(id: number) {
    this.router.navigate(['/funcionario/editar', id]);
  }
}
