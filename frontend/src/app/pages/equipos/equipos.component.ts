import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { Equipo } from '../../models/equipo.model';
import { EquipoService } from '../../services/equipo.service';
import { EquipoDialogComponent } from './equipo-dialog.component';

@Component({
  selector: 'app-equipos',
  standalone: true,
  imports: [CommonModule, FormsModule, MatCardModule, MatDialogModule],
  templateUrl: './equipos.component.html',
  styleUrl: './equipos.component.scss'
})
export class EquiposComponent implements OnInit {

  equipos: Equipo[] = [];
  filtro: string = '';

  constructor(
    private equipoService: EquipoService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.equipoService.obtenerTodos().subscribe({
      next: (data) => this.equipos = data,
      error: (err) => console.log("Error cargando equipos: ", err)
    })
  }

  get equiposFiltrados(): Equipo[] {
    if (!this.filtro.trim()) return this.equipos;
    return this.equipos.filter(e =>
      e.pais.toLowerCase().includes(this.filtro.toLowerCase())
    );
  }

  abrirDialogo(equipo: Equipo): void {
    this.dialog.open(EquipoDialogComponent, {
      data: equipo,
      width: '500px',
      maxHeight: '90vh'
    });
  }

}
