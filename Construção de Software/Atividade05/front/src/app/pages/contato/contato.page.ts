import { Component } from '@angular/core';
import { ButtonPadraoComponent } from "../../component/button-padrao/button-padrao.component";
import { Contato, ContatoService } from '../../services/contato.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contato',
  imports: [ButtonPadraoComponent, FormsModule],
  templateUrl: './contato.page.html',
  styleUrl: './contato.page.scss'
})
export class ContatoPage {
  nomeNovoContato: string = '';
  emailNovoContato: string = '';
  telefoneNovoContato: string = '';

  constructor(private contatoService: ContatoService){

  }
  
  salvarContato() {
    const novoContato: Contato = {
      nome: this.nomeNovoContato,
      email: this.emailNovoContato,
      telefone: this.telefoneNovoContato
    };

    this.contatoService.create(novoContato).subscribe({
      next: (res) => {
        console.log('Contato salvo com sucesso: ', res);
      }
    })

    this.nomeNovoContato = '';
    this.emailNovoContato = '';
    this.telefoneNovoContato = '';
  }
}
