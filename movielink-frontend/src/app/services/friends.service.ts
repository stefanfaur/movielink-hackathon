import { Injectable } from '@angular/core';


import {apiUrl} from "./url.config";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FriendVO} from "../models/friends";

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  constructor(private http: HttpClient) { }

  getFriends(): Observable<FriendVO[]> {
    return this.http.get<FriendVO[]>(`${apiUrl}/friends`);
  }

  // friendEmail in request param
  addFriend(friendEmail: string): Observable<FriendVO> {
    return this.http.post<FriendVO>(`${apiUrl}/friends/add`, { friendEmail: friendEmail });
  }

}
