import { Component, OnInit } from '@angular/core';
import { Equipo } from '../../models/equipo.model';
import { EquipoService } from '../../services/equipo.service';
import { MatCardModule } from "@angular/material/card";
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-equipos',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatTableModule],
  templateUrl: './equipos.component.html',
  styleUrl: './equipos.component.scss'
})
export class EquiposComponent implements OnInit{

  equipos: Equipo[] = [];

  constructor(private equipoService: EquipoService){}
  
  ngOnInit(): void{
    this.equipoService.obtenerTodos().subscribe({
      next:(data) => this.equipos = data,
      error:(err) => console.log("Error cargando equipos: ", err)
    })
  }

}
