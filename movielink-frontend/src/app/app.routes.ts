import { Routes } from '@angular/router';
import {FriendsComponent} from "./friends/friends.component";
import {LoginComponent} from "./auth/login/login.component";
import {RegisterComponent} from "./auth/register/register.component";
import {GroupComponent} from "./group/group.component";
import {GroupListComponent} from "./group-list/group-list.component";

export const routes: Routes = [
  { path: '', redirectTo: 'groups', pathMatch: 'full' },
  { path: 'friends', component: FriendsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'groups', component: GroupListComponent },
  { path: 'groups/:id', component: GroupComponent },
];
