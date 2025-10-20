import { Component } from '@angular/core';
import { TabelaPadraoComponent } from "../tabela-padrao/tabela-padrao.component";

@Component({
  selector: 'app-home',
  imports: [TabelaPadraoComponent],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home {

}
