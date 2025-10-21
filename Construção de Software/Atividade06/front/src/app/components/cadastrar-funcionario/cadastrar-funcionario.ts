import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario, FuncionarioRequest, FuncionarioService } from '../../services/funcionario.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastrar-funcionario',
  imports: [CommonModule, FormsModule],
  templateUrl: './cadastrar-funcionario.html',
  styleUrl: './cadastrar-funcionario.scss'
})
export class CadastrarFuncionario {
      nome: string = '';
      email: string = '';
      cargo: string = '';
      salario: number = 0;

    constructor(
      private router: Router,
      private funcionarioService: FuncionarioService
    ) {}


    EditarFuncionario(id: number) {
      this.funcionarioService.findById(id).subscribe({
        next: (func: Funcionario) => {
          this.nome = func.nome;
          this.email = func.email;
          this.cargo = func.cargo;
          this.salario = func.salario;
        },
        error: (err) => console.error('Erro ao carregar funcionário:', err)
      });
    }

    salvar() {
      const funcionario: FuncionarioRequest = {
        nome: this.nome,
        email: this.email,
        cargo: this.cargo,
        salario: this.salario,
      };

      this.funcionarioService.create(funcionario).subscribe({
          next: res => this.router.navigate(['/']),
          error: err => console.error('Erro ao criar', err)
      });
    }
}
