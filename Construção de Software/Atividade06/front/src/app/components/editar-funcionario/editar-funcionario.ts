import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario, FuncionarioRequest, FuncionarioService } from '../../services/funcionario.service';

@Component({
  selector: 'app-editar-funcionario',
  imports: [CommonModule, FormsModule],
  templateUrl: './editar-funcionario.html',
  styleUrl: './editar-funcionario.scss'
})
export class EditarFuncionario implements OnInit {

    idFuncionario: number = 0;
    nome: string = '';
    email: string = '';
    cargo: string = '';
    salario: number = 0;
    status: boolean = true;
    isEditando: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private funcionarioService: FuncionarioService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam) {
        this.idFuncionario = +idParam;
        this.EditarFuncionario(this.idFuncionario);
      }
    });
  }

  EditarFuncionario(id: number) {
    this.funcionarioService.findById(id).subscribe({
      next: (func: Funcionario) => {
        this.nome = func.nome;
        this.email = func.email;
        this.cargo = func.cargo;
        this.salario = func.salario;
        this.status = func.status;
        this.isEditando = true;
      },
      error: (err) => console.error('Erro ao carregar funcionário:', err)
    });
  }

  salvar() {
    const funcionario: FuncionarioRequest = {
      id: this.idFuncionario,
      nome: this.nome,
      email: this.email,
      cargo: this.cargo,
      salario: this.salario,
      status: this.status
    };

    this.funcionarioService.update(this.idFuncionario, funcionario).subscribe({
      next: res => this.router.navigate(['/lista']),
      error: err => console.error('Erro ao atualizar', err)
    });
  }

  inativarFuncionario() {
    this.funcionarioService.inativar(this.idFuncionario).subscribe({
      next: res => this.router.navigate(['/lista']),
      error: err => console.error('Erro ao atualizar', err)
    });
  }
}
