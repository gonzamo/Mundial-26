import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialogModule, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { Equipo } from '../../models/equipo.model';

@Component({
  selector: 'app-equipo-dialog',
  standalone: true,
  imports: [CommonModule, MatDialogModule, MatCardModule],
  templateUrl: './equipo-dialog.component.html',
  styleUrl: './equipo-dialog.component.scss'
})
export class EquipoDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<EquipoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public equipo: Equipo
  ) {}

  cerrar(): void {
    this.dialogRef.close();
  }

  clasePosicion(posicion: string): string {
    switch (posicion) {
      case 'PORTERO':   return 'bg-portero';
      case 'DEFENSA':   return 'bg-defensa';
      case 'MEDIOCAMPISTA': return 'bg-mediocampista';
      case 'DELANTERO': return 'bg-delantero';
      default:          return '';
    }
  }
}
