// fanzone.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Corrida {
  nome: string;
  data: string;
  usuarios: any[];
}

export interface Usuario {
  nome: string;
  notificacoesAtivas: boolean;
}

@Injectable({
  providedIn: 'root'
})

export class FanzoneService {
    private apiUrl = 'http://localhost:8080/fanzone';

    constructor(private http: HttpClient) { }

    adicionarEvento(corrida: Corrida): Observable<string> {
        return this.http.post(`${this.apiUrl}/evento`, corrida, { responseType: 'text' });
    }

    registrarUsuario(usuario: Usuario): Observable<string> {
        return this.http.post(`${this.apiUrl}/usuario`, usuario, { responseType: 'text' });
    }


    inscreverUsuario(nomeUsuario: string, nomeEvento: string): Observable<string> {
        return this.http.post(`${this.apiUrl}/inscrever?nomeUsuario=${nomeUsuario}&nomeEvento=${nomeEvento}`, {}, { responseType: 'text' });
    }

    pularDia(): Observable<string> {
        return this.http.post(`${this.apiUrl}/pularDia`, {}, { responseType: 'text' });
    }
}
