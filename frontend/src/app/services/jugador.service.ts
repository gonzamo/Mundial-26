import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jugador } from '../models/jugador.model';

@Injectable({ providedIn: 'root' })
export class JugadorService {

  private apiUrl = 'http://localhost:8080/api/jugadores';

  constructor(private http: HttpClient) {}

  obtenerTodos(): Observable<Jugador[]> {
    return this.http.get<Jugador[]>(this.apiUrl);
  }

  obtenerPorEquipo(equipoId: number): Observable<Jugador[]> {
    return this.http.get<Jugador[]>(`${this.apiUrl}?equipoId=${equipoId}`);
  }
}