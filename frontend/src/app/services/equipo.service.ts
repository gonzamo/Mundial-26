import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipo } from '../models/equipo.model';

@Injectable({ providedIn: 'root' })
export class EquipoService {

  private apiUrl = 'http://localhost:8080/api/equipos';

  constructor(private http: HttpClient) {}

  obtenerTodos(): Observable<Equipo[]> {
    return this.http.get<Equipo[]>(this.apiUrl);
  }

  obtenerPorId(id: number): Observable<Equipo> {
    return this.http.get<Equipo>(`${this.apiUrl}/${id}`);
  }
}