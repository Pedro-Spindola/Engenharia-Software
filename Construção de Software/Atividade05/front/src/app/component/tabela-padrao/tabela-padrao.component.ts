import { Component, OnInit } from '@angular/core';
import { Contato, ContatoService } from '../../services/contato.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tabela-padrao',
  imports: [CommonModule],
  templateUrl: './tabela-padrao.component.html',
  styleUrl: './tabela-padrao.component.scss'
})

export class TabelaPadraoComponent implements OnInit {
  contatos: Contato[] = [];

  constructor(private contatoService: ContatoService) {}

  ngOnInit(): void {
    this.contatoService.findAll().subscribe({
      next: (dados) => {
        this.contatos = dados;
      },
      error: (erro) => {

        console.error('Erros ao buscar contatos: ', erro);
      }
    });
  }
}
