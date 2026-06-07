import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { PartidoService } from '../../services/partido.service';
import { Partido } from '../../models/partido.model';

@Component({
  selector: 'app-partidos',
  standalone: true,
  imports: [CommonModule, FormsModule, MatCardModule, MatChipsModule],
  templateUrl: './partidos.component.html',
  styleUrl: './partidos.component.scss'
})
export class PartidosComponent implements OnInit {

  partidos: Partido[] = [];
  fases: string[] = [];
  filtro = '';

  constructor(private partidoService: PartidoService) {}

  ngOnInit(): void {
    this.partidoService.obtenerTodos().subscribe({
      next: (data) => {
        this.partidos = data;
        this.fases = [...new Set(data.map(p => p.fase))];
      },
      error: (err) => console.error('Error cargando partidos', err)
    });
  }

  get partidosFiltrados(): Partido[] {
    if (!this.filtro.trim()) return this.partidos;
    const term = this.filtro.toLowerCase();
    return this.partidos.filter(p =>
      p.equipoLocal.pais.toLowerCase().includes(term) ||
      p.equipoVisitante.pais.toLowerCase().includes(term)
    );
  }

  filtrarPorFase(fase: string): Partido[] {
    return this.partidosFiltrados.filter(p => p.fase === fase);
  }

  getEstadoClass(estado: string): string {
    switch (estado) {
      case 'PROGRAMADO': return 'estado-programado';
      case 'EN_JUEGO': return 'estado-enjuego';
      case 'FINALIZADO': return 'estado-finalizado';
      default: return '';
    }
  }
}
