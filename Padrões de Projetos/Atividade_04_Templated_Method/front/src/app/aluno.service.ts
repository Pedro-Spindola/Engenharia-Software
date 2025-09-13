import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Aluno {
    nome: string;
    curso: string;
    situacao: string;
    enfase: string;
}

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  // Substitua pela URL da sua API
  private apiUrl = 'http://localhost:8080/alunos';

  constructor(private http: HttpClient) { }

  getAlunosOrdenadosPorCursoEnfase(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarCursoEnfase`);
  }

  getAlunosOrdenadosPorCursoNome(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarCursoNome`);
  }

  getAlunosOrdenadosPorEnfaseCurso(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarEnfaseCurso`);
  }

  getAlunosOrdenadosPorEnfaseNome(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarEnfaseNome`);
  }

  getAlunosOrdenadosPorNome(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarNome`);
  }

  getAlunosOrdenadosPorSituacaoNome(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarSitucaoNome`);
  }

  getAlunosOrdenadosPorSobrenome(): Observable<Aluno[]> {
    return this.http.get<Aluno[]>(`${this.apiUrl}/ordenarSobrenome`);
  }
}