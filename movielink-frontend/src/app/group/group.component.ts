import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GroupService } from '../services/group.service';
import { NgForOf } from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  standalone: true,
  imports: [NgForOf, FormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {
  group: any;
  newPost: any = {
    title: '',
    content: '',
    location: '',
    rating: 0,
    groupId: 0,
  };

  constructor(private route: ActivatedRoute, private groupService: GroupService) {}

  ngOnInit(): void {
    const groupIdString = this.route.snapshot.paramMap.get('id');
    const groupId = groupIdString ? parseInt(groupIdString) : 0;
    this.groupService.getGroup(groupId).subscribe(group => {
      this.group = group;
    });
    this.newPost.groupId = groupId;
  }

  onSubmit(): void {
    const groupIdString = this.route.snapshot.paramMap.get('id');
    const groupId = groupIdString ? parseInt(groupIdString) : 0;
    console.log(this.newPost);
    console.log("groupId: ", groupId);
    this.groupService.addPost(groupId, this.newPost).subscribe(post => {
      this.group.posts.push(post);
      this.newPost = {
        title: '',
        content: '',
        location: '',
        rating: 0,
      };
    });
  }
}
