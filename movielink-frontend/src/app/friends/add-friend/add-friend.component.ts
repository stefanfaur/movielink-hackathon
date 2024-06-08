import {Component} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {FriendsService} from "../../services/friends.service";
import {MatCardModule} from "@angular/material/card";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-add-friend',
  standalone: true,
  imports: [
    MatCardModule,
    FormsModule,
    MatFormField,
    MatLabel,
    MatButton,
    MatInput
  ],
  templateUrl: './add-friend.component.html',
  styleUrl: './add-friend.component.css'
})
export class AddFriendComponent {

  email: string = '';

  constructor(private friendsService: FriendsService) {}

  addFriend() {
    console.log("Got button press");
    this.friendsService.addFriend(this.email).subscribe(
      (response) => {
        console.log("Friend added successfully");
      },
      (error) => {
        console.log("Error adding friend");
      }
    );
  }
}
