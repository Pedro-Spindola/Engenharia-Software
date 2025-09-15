import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CafeService {
  private apiUrl = 'http://localhost:8080/api/cafes/pedido';

  constructor(private http: HttpClient) { }

  // Envia o pedido para o back-end
  processarPedido(tipoCafe: string, adicionais: string[]): Observable<any> {
    const pedido = { tipo: tipoCafe, adicionais: adicionais };
    return this.http.post(this.apiUrl, pedido);
  }
}