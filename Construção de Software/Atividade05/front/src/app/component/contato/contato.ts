import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { ButtonModule } from 'primeng/button';
import { ContatoService, IContato } from '../../contato.service';

@Component({
  selector: 'app-contato',
  standalone: true,
  imports: [CommonModule, InputTextModule, FloatLabelModule, FormsModule, ButtonModule],
  templateUrl: './contato.html',
  styleUrl: './contato.scss'
})
export class Contato {
  labelNome: string = "Seu nome";
  labelTelefone: string = "Seu telefone";
  nomeNewContato: string = '';
  telefoneNewContato: string = '';

  constructor(private contatoService: ContatoService){

  }

  novoContato(): void {
    const novo: IContato = {
      nome: this.nomeNewContato,
      telefone: this.telefoneNewContato
    };

    this.contatoService.add(novo);
    console.log(this.contatoService.findAll());

    this.nomeNewContato = '';
    this.telefoneNewContato = '';
  }
}
