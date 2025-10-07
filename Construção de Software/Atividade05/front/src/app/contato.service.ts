import { Injectable } from '@angular/core';

export interface IContato {
  id?: number;
  nome: string;
  telefone: string;
}

@Injectable({
  providedIn: 'root'
})

export class ContatoService{
    listaContato: IContato[] = [];
    id: number = 0;

    constructor(){}

    add(contato: IContato): void {
        contato.id = this.proximoId();
        this.listaContato.push(contato);
    }

    private proximoId(): number {
        this.id++;
        return this.id;
    }

    findAll(): IContato[] {
        return this.listaContato;
    }
}