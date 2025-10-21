import { Component } from '@angular/core';
import { TabelaPadraoComponent } from "../tabela-padrao/tabela-padrao.component";

@Component({
  selector: 'app-lista',
  imports: [TabelaPadraoComponent],
  templateUrl: './lista.html',
  styleUrl: './lista.scss'
})
export class Lista {

}
