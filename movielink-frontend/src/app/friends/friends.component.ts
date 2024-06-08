import {Component, OnInit} from '@angular/core';
import {FriendsService} from "../services/friends.service";
import {MatButton} from "@angular/material/button";
import {MatList, MatListItem} from "@angular/material/list";
import {MatLine} from "@angular/material/core";
import {NgForOf} from "@angular/common";
import {Observable} from "rxjs";
import {FriendVO} from "../models/friends";
import {MatCardModule} from "@angular/material/card";
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import {AddFriendComponent} from "./add-friend/add-friend.component";

@Component({
  selector: 'app-friends',
  standalone: true,
  imports: [
    MatButton,
    MatList,
    MatListItem,
    MatLine,
    NgForOf,
    MatCardModule,
    MatDialogModule
  ],
  templateUrl: './friends.component.html',
  styleUrl: './friends.component.css'
})
export class FriendsComponent implements OnInit{

  constructor(private friendsService: FriendsService, public dialog: MatDialog) {
  }

  friends: FriendVO[] = [];
  selectedFriends: FriendVO[] = []; // This is used to store the selected friends for creating a group

  getFriends() {
    this.friendsService.getFriends().subscribe(
      (response) => {
        this.friends = response;
      },
      (error) => {
        console.log('Error fetching friends');
      }
    );
  }

  openDialog() {
    const dialogRef = this.dialog.open(AddFriendComponent, {
      width: '350px',
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }



  ngOnInit(): void {
    this.getFriends();
  }
}
