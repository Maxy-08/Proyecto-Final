import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs'; // <-- Agrega 'of' aquí
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/usuario';
  private isBrowser: boolean;

  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object,
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId);
  }

  login(email: string, password: string): Observable<any> {
    const options = {
      withCredentials: true,
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.post<any>(`${this.apiUrl}/login`, { correo: email, contrasena: password }, options).pipe(
      tap(response => {
        if (response.token && this.isBrowser) {
          localStorage.setItem('token', response.token);
          localStorage.setItem('usuario', JSON.stringify(response.usuario));
          localStorage.setItem('rol', response.rolUsuario); 
          localStorage.setItem('idSucursal', response.idSucursal); 
        }
      })
    );
  }

  // MODIFICACIÓN EN LOGOUT: Limpia el almacenamiento sin pedir permiso al Backend
  logout(): Observable<void> {
    if (this.isBrowser) {
      localStorage.removeItem('token');
      localStorage.removeItem('usuario');
      localStorage.removeItem('idSucursal');
      localStorage.removeItem('rol');
      localStorage.clear(); // Opcional: borra todo el almacenamiento de una vez
    }
    return of(undefined); // Devuelve un Observable completado para no romper componentes que esperen la suscripción
  }

  isAuthenticated(): boolean {
    return this.isBrowser && !!this.getToken();
  }

  getToken(): string | null {
    return this.isBrowser ? localStorage.getItem('token') : null;
  }

  getUsuario(): any {
    return this.isBrowser ? JSON.parse(localStorage.getItem('usuario')!) : null;
  }

  getIdSucursal(): string | null {
    return this.isBrowser ? localStorage.getItem('idSucursal') : null;
  }

  getRol(): string | null {
    return this.isBrowser ? localStorage.getItem('rol') : null;
  }
}