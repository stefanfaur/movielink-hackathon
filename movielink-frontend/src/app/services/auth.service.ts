import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {apiUrl} from "./url.config";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private tokenKey = 'authToken';



  constructor(private http: HttpClient) {
  }

  login(email: string, password: string): Observable<{ token: string }> {
    return this.http.post<{ token: string, expiresIn: number }>(`${apiUrl}/auth/login`, {email, password}).pipe(
      tap((response) => {
        this.setToken(response.token);
        // TODO: actually do something with this
        this.setExpiry(response.expiresIn);
      })
    );
  }

  register(email: string, password: string, fullName: string): Observable<{ token: string }> {
    return this.http.post<{ token: string }>(`${apiUrl}/auth/signup`, {email, password, fullName});
  }

  setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  setExpiry(expiry: number): void {
    localStorage.setItem('expiresIn', expiry.toString());
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }

  isAuthenticated(): boolean {
    return !!this.getToken();
  }
}
