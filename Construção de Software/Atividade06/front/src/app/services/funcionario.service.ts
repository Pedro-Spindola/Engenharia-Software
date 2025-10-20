import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface FuncionarioRequest {
  id?: number;
  nome: string;
  email: string;
  cargo: string;
  salario: number;
  status: boolean;
}

export interface Funcionario {
  id?: number;
  nome: string;
  email: string;
  cargo: string;
  salario: number;
  dataAdmissao: string;
  status: boolean;
}

@Injectable({
  providedIn: 'root'
})

export class FuncionarioService {
  
  private readonly apiUrl = 'http://localhost:8080/api/v1/funcionario';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Funcionario[]> {
    return this.http.get<Funcionario[]>(this.apiUrl).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }

  create(funcionario: FuncionarioRequest): Observable<Funcionario> {
    return this.http.post<Funcionario>(this.apiUrl, funcionario)
      .pipe(catchError(this.handleError));
  }

  /** 🔹 Atualiza um funcionário existente */
  update(id: number, funcionario: FuncionarioRequest): Observable<Funcionario> {
    return this.http.put<Funcionario>(`${this.apiUrl}/${id}`, funcionario)
      .pipe(catchError(this.handleError));
  }

  /** 🔹 Busca um funcionário por ID */
  findById(id: number): Observable<Funcionario> {
    return this.http.get<Funcionario>(`${this.apiUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

}
