import { Component, OnInit } from '@angular/core';
import { Funcionario, FuncionarioRequest, FuncionarioService } from '../../services/funcionario.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-funcionario-acao',
  imports: [CommonModule, FormsModule],
  templateUrl: './funcionario-acao.html',
  styleUrl: './funcionario-acao.scss'
})
export class FuncionarioAcao implements OnInit {

  idFuncionario?: number;
  nome: string = '';
  email: string = '';
  cargo: string = '';
  salario: number = 0;
  status: boolean = true;
  isEditando: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private funcionarioService: FuncionarioService
  ) {}

  ngOnInit(): void {
    // Lê o parâmetro 'id' da rota
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
      nome: this.nome,
      email: this.email,
      cargo: this.cargo,
      salario: this.salario,
      status: this.status
    };

    if (this.isEditando && this.idFuncionario) {
      this.funcionarioService.update(this.idFuncionario, funcionario).subscribe({
        next: res => console.log('Atualizado com sucesso', res),
        error: err => console.error('Erro ao atualizar', err)
      });
    } else {
      this.funcionarioService.create(funcionario).subscribe({
        next: res => console.log('Criado com sucesso', res),
        error: err => console.error('Erro ao criar', err)
      });
    }
  }
}