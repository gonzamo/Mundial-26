import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username = '';
  password = '';
  error = '';
  esRegistro = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  login(): void {
    if (!this.username || !this.password) {
      this.error = 'Completa todos los campos';
      return;
    }

    const obs = this.esRegistro
      ? this.authService.registro({ username: this.username, password: this.password })
      : this.authService.login({ username: this.username, password: this.password });

    obs.subscribe({
      next: (res) => {
        this.authService.guardarToken(res.token);
        this.router.navigate(['/grupos']);
      },
      error: () => {
        this.error = this.esRegistro
          ? 'El usuario ya existe'
          : 'Usuario o contraseña incorrectos';
      }
    });
  }

  toggleModo(): void {
    this.esRegistro = !this.esRegistro;
    this.error = '';
  }

}
