import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Piloto {
  matricula: number;
  nome: string;
  nacionalidade: string;
  idade: number;
  equipe: string;
  motor: string;
  pontos: number;
}

@Injectable({
  providedIn: 'root'
})
export class PilotoService {
  private apiUrl = 'http://localhost:8080/pilotos'; // Substitua pela URL da sua API

  constructor(private http: HttpClient) {}

  uploadArquivo(file: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(`${this.apiUrl}/upload`, formData);
  }

  getPilotos(tipoEstrutura: string): Observable<Piloto[]> {
    return this.http.get<Piloto[]>(`${this.apiUrl}/${tipoEstrutura}`);
  }
}