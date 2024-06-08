import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { apiUrl} from "./url.config";

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) { }

  getGroups(): Observable<any[]> {
    return this.http.get<any[]>(`${apiUrl}/group`);
  }

  getGroup(id: number): Observable<any> {
    return this.http.get<any>(`${apiUrl}/group/${id}`);
  }

  addPost(groupId: number, post: any): Observable<any> {
    return this.http.post(`${apiUrl}/group/${groupId}/add`, post);
  }
}
