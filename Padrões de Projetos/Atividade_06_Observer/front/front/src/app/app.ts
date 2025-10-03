import { Component } from '@angular/core';
import { Corrida, FanzoneService, Usuario } from './fanzone.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  eventos: Corrida[] = [];
  usuarios: Usuario[] = [];
  mensagens: string[] = [];

  constructor(private service: FanzoneService) { }

  adicionarEvento() {
    const corrida: Corrida = { nome: 'GP Interlagos', data: new Date().toISOString().split('T')[0], usuarios: [] };
    this.service.adicionarEvento(corrida).subscribe(msg => this.mensagens.push(msg));
  }

  registrarUsuario() {
    const usuario: Usuario = { nome: 'Pedro', notificacoesAtivas: true };
    this.service.registrarUsuario(usuario).subscribe(msg => this.mensagens.push(msg));
  }

  inscreverUsuario() {
    this.service.inscreverUsuario('Pedro', 'GP Interlagos').subscribe(msg => this.mensagens.push(msg));
  }

  pularDia() {
    this.service.pularDia().subscribe(msg => this.mensagens.push(msg));
  }
}
