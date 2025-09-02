import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Antena {
  id: number;
  modelo: string;
  dbi: number;
  frequencia: string;
  tipoConector: string;
}

export interface Chipset {
  id: number;
  modelo: string;
  velocidadeDeClock: number;
  tipoConector: string;
}

export interface Fonte {
  id: number;
  fabricante: string;
  voltagem: number;
  tipoConector: string;
}

export interface Placa {
  id: number;
  modelo: string;
  taxaTransferencia: number;
  tipoConectorAntena: string;
  tipoConectorChipset: string;
  tipoConectorFonte: string;
}

export interface AdapterConectorDTO {
  entrada: string;
  saida: string;
}

export interface Roteador {
  id?: number;
  modeloRoteador: string;
  fabricante: string;
  antena: Antena;
  chipset: Chipset;
  fonteAlimentacao: Fonte;
  placaDeRede: Placa;
  adapterAntena?: AdapterConectorDTO;
  adapterChipset?: AdapterConectorDTO;
  adapterFonte?: AdapterConectorDTO;
}

export interface RoteadorDTO {
  modeloRoteador: string;
  fabricante: string;
  antenaId: number;
  chipsetId: number;
  fonteId: number;
  placaId: number;
} 

export interface RoteadorLigacaoResponseDTO {
  id: number;
  modeloRoteador: string;
  fabricante: string;
  diagnostico: string[];
  adapterAntena?: AdapterConectorDTO;
  adapterChipset?: AdapterConectorDTO;
  adapterFonte?: AdapterConectorDTO;
  status: string;
}

export interface RoteadorComponentesResponseDTO {
  id: number;
  modeloRoteador: string;
  fabricante: string;
  antena: any;
  chipset: any;
  fonteAlimentacao: any;
  placaDeRede: any;
  adapterAntena?: AdapterConectorDTO;
  adapterChipset?: AdapterConectorDTO;
  adapterFonte?: AdapterConectorDTO;
}


@Injectable({
  providedIn: 'root',
})
export class SimuladorService {
  private apiUrl = 'http://localhost:8080/simulador';

  constructor(private http: HttpClient) {}

  getAntenas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/antenas`);
  }

  getChipsets(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/chipsets`);
  }

  getFontes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/fontes`);
  }

  getPlacas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/placas`);
  }

  getRoteadores(): Observable<Roteador[]> {
    return this.http.get<Roteador[]>(`${this.apiUrl}/roteadores`);
  }

  criarRoteador(dto: any): Observable<Roteador> {
    return this.http.post<Roteador>(`${this.apiUrl}/roteadores`, dto);
  }

  getRoteadorComponentes(id: number) {
    return this.http.get<RoteadorComponentesResponseDTO>(`${this.apiUrl}/roteadores/${id}/componentes`);
  }

  ligarRoteador(id: number) {
    return this.http.post<RoteadorLigacaoResponseDTO>(`${this.apiUrl}/roteadores/${id}/ligar`, {});
  }

}
