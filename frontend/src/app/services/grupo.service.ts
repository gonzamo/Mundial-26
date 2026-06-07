import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Grupo } from '../models/grupo.model';

@Injectable({ providedIn: 'root' })
export class GrupoService {

  private apiUrl = 'http://localhost:8080/api/grupos';

  constructor(private http: HttpClient) {}

  obtenerTodos(): Observable<Grupo[]> {
    return this.http.get<Grupo[]>(this.apiUrl);
  }
}