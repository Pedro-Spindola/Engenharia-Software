import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Funcionario, FuncionarioService} from '../../services/funcionario.service';

@Component({
  selector: 'app-tabela-padrao',
  imports: [CommonModule],
  templateUrl: './tabela-padrao.component.html',
  styleUrl: './tabela-padrao.component.scss'
})

export class TabelaPadraoComponent implements OnInit {
  funcionario: Funcionario[] = [];

  constructor(private funcionarioService: FuncionarioService, private router: Router) {}

  ngOnInit(): void {
    this.funcionarioService.findAll().subscribe({
      next: (dados) => {
        this.funcionario = dados;
      },
      error: (erro) => {

        console.error('Erros ao buscar contatos: ', erro);
      }
    });
  }

  EditarFuncionario(id: number) {
    this.router.navigate(['/funcionario/editar', id]);
  }
}
