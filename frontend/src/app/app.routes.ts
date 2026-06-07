import { Routes } from '@angular/router';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    loadComponent: () => import('./pages/login/login.component')
      .then(m => m.LoginComponent)
  },
  {
    path: 'grupos',
    loadComponent: () => import('./pages/grupos/grupos.component')
      .then(m => m.GruposComponent),
    canActivate: [authGuard]
  },
  {
    path: 'equipos',
    loadComponent: () => import('./pages/equipos/equipos.component')
      .then(m => m.EquiposComponent),
    canActivate: [authGuard]
  },
  {
    path: 'partidos',
    loadComponent: () => import('./pages/partidos/partidos.component')
      .then(m => m.PartidosComponent),
    canActivate: [authGuard]
  },
  { path: '**', redirectTo: 'login' }
];