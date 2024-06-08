import { Component, OnInit } from '@angular/core';
import { GroupService } from '../services/group.service';
import { NavigationService } from '../services/navigation.service';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  standalone: true,
  imports: [
    NgForOf
  ],
  styleUrls: ['./group-list.component.css']
})
export class GroupListComponent implements OnInit {
  groups: any[] = [];

  constructor(private groupService: GroupService, private navigationService: NavigationService) {}

  ngOnInit(): void {
    this.groupService.getGroups().subscribe(groups => {
      this.groups = groups;
    });
  }

  navigateToGroup(groupId: number): void {
    this.navigationService.navigateToGroup(groupId);
  }
}
