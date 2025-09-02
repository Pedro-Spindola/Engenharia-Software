import { Component, OnInit } from '@angular/core';
import { SimuladorService, Antena, Chipset, Fonte, Placa, Roteador, RoteadorDTO, RoteadorLigacaoResponseDTO } from './services/simulado.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class App implements OnInit {
  antenas: Antena[] = [];
  chipsets: Chipset[] = [];
  fontes: Fonte[] = [];
  placas: Placa[] = [];

  antenaSelecionada!: Antena;
  chipsetSelecionado!: Chipset;
  fonteSelecionada!: Fonte;
  placaSelecionada!: Placa;

  roteadorMontado!: Roteador;
  diagnosticoTexto = '';
  diagnosticoGerado = false;
  modeloRoteador: string = '';

  constructor(private simuladorService: SimuladorService) {}

  ngOnInit(): void {
    this.simuladorService.getAntenas().subscribe(data => this.antenas = data);
    this.simuladorService.getChipsets().subscribe(data => this.chipsets = data);
    this.simuladorService.getFontes().subscribe(data => this.fontes = data);
    this.simuladorService.getPlacas().subscribe(data => this.placas = data);
  }

  podeMontar(): boolean {
    return !!(this.antenaSelecionada && this.chipsetSelecionado && this.fonteSelecionada && this.placaSelecionada);
  }

  montarRoteador(): void {
    const dto: RoteadorDTO = {
      modeloRoteador: this.modeloRoteador,
      fabricante: "TechSeven",
      antenaId: this.antenaSelecionada.id,
      chipsetId: this.chipsetSelecionado.id,
      fonteId: this.fonteSelecionada.id,
      placaId: this.placaSelecionada.id,
    };

    this.simuladorService.criarRoteador(dto).subscribe({
      next: roteador => {
        this.roteadorMontado = roteador;
        console.log("Roteador criado:", roteador);
      },
      error: err => console.error("Erro ao criar roteador:", err)
    });
  }

  gerarDiagnostico(): void {
    if (!this.roteadorMontado?.id) return;

    this.simuladorService.ligarRoteador(this.roteadorMontado.id).subscribe({
      next: (resp: RoteadorLigacaoResponseDTO) => {
        const linhas: string[] = [];

        linhas.push(`Ligando Roteador: ${resp.modeloRoteador} - ${resp.fabricante}\n`);

        // Mensagens de diagnóstico do backend
        resp.diagnostico.forEach(msg => linhas.push(msg));

        // Adapters (se existirem)
        if (resp.adapterAntena) {
          linhas.push(`⚠️ Adapter usado na Antena: ${resp.adapterAntena.entrada} ➜ ${resp.adapterAntena.saida}`);
        }
        if (resp.adapterChipset) {
          linhas.push(`⚠️ Adapter usado no Chipset: ${resp.adapterChipset.entrada} ➜ ${resp.adapterChipset.saida}`);
        }
        if (resp.adapterFonte) {
          linhas.push(`⚠️ Adapter usado na Fonte: ${resp.adapterFonte.entrada} ➜ ${resp.adapterFonte.saida}`);
        }

        // Status final
        linhas.push(`\n${resp.status}`);

        this.diagnosticoTexto = linhas.join('\n');
        this.diagnosticoGerado = true;
      },
      error: err => console.error("Erro ao gerar diagnóstico:", err)
    });
  }
}
