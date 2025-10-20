import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

export interface Contato {
  id?: number;
  nome: string;
  email: string;
  telefone: string;
}

@Injectable({
  providedIn: 'root'
})

export class ContatoService {

  private readonly apiUrl = 'http://localhost:8080/api/v1/contatos';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Contato[]> {
    return this.http.get<Contato[]>(this.apiUrl).pipe(catchError(this.handleError));
  }

  findById(id: number): Observable<Contato> {
    return this.http.get<Contato>(`${this.apiUrl}/${id}`).pipe(catchError(this.handleError));
  }

  create(body: Contato): Observable<Contato>{
    return this.http.post<Contato>(this.apiUrl, body).pipe(catchError(this.handleError));
  }

  update(id: number, body: Contato): Observable<Contato>{
    return this.http.put<Contato>(`${this.apiUrl}/${id}`, body).pipe(catchError(this.handleError));
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(catchError(this.handleError));
  }

  private handleError(error: any){
    console.error('Erro na API: ', error);
    return throwError(() => new Error('Erro ao consultar a API de contatos.'))
  }

}
