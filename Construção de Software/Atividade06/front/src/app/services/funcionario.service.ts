import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface FuncionarioRequest {
  id?: number;
  nome: string;
  email: string;
  cargo: string;
  salario: number;
  status?: boolean;
  id_departamento: number;
}

export interface Funcionario {
  id?: number;
  nome: string;
  email: string;
  cargo: string;
  salario: number;
  dataAdmissao: string;
  status: boolean;
  departamentoResponseDTO: DepartamentoRequest;
}

export interface DepartamentoRequest{
  id?: number;
  nome: String;
  sigla: String;
  ativo: boolean;
}

@Injectable({
  providedIn: 'root'
})

export class FuncionarioService {
  
  private readonly apiUrl = 'http://localhost:8080/api/v2/funcionario';

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

  update(id: number, funcionario: FuncionarioRequest): Observable<Funcionario> {
    return this.http.put<Funcionario>(this.apiUrl, funcionario)
      .pipe(catchError(this.handleError));
  }

  inativar(id: number): Observable<boolean> {
    return this.http.put<boolean>(`${this.apiUrl}/${id}`, {}).pipe(
      catchError(this.handleError)
    );
  }

  findById(id: number): Observable<Funcionario> {
    return this.http.get<Funcionario>(`${this.apiUrl}/${id}`)
      .pipe(catchError(this.handleError));
  }

}
