import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { GrupoService } from '../../services/grupo.service';
import { Grupo } from '../../models/grupo.model';

@Component({
  selector: 'app-grupos',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule],
  templateUrl: './grupos.component.html',
  styleUrl: './grupos.component.scss'
})
export class GruposComponent implements OnInit {

  grupos: Grupo[] = [];

  constructor(private grupoService: GrupoService) {}

  ngOnInit(): void {
    this.grupoService.obtenerTodos().subscribe({
      next: (data) => this.grupos = data,
      error: (err) => console.error('Error cargando grupos', err)
    });
  }

}