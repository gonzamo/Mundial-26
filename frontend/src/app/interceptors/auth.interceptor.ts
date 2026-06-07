import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';

//Es como un portero que intercepta todas las peticiones HTTP 
//antes de que salgan hacia el backend.
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const router = inject(Router);
  const token = authService.obtenerToken();

  const reqClone = token ? req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`)
  }) : req;

  return next(reqClone).pipe(
    catchError((error: HttpErrorResponse) => {
      if (error.status === 401 || error.status === 403) {
        authService.cerrarSesion();
        router.navigate(['/login']);
      }
      return throwError(() => error);
    })
  );
};