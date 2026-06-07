import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partido } from '../models/partido.model';

@Injectable({ providedIn: 'root' })
export class PartidoService {

  private apiUrl = 'http://localhost:8080/api/partidos';

  constructor(private http: HttpClient) {}

  obtenerTodos(): Observable<Partido[]> {
    return this.http.get<Partido[]>(this.apiUrl);
  }
}