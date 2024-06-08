package hack.movielink.controller;

import hack.movielink.domain.group.dto.FriendGroupSingleVO;
import hack.movielink.domain.group.dto.FriendGroupVO;
import hack.movielink.domain.group.entity.FriendGroup;
import hack.movielink.domain.group.entity.Post;
import hack.movielink.domain.user.entity.User;
import hack.movielink.service.GroupService;
import hack.movielink.service.PostService;
import hack.movielink.service.auth.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;
    private final JwtService jwtService;
    private final PostService postService;

    public GroupController(GroupService groupService, JwtService jwtService, PostService postService) {
        this.groupService = groupService;
        this.jwtService = jwtService;
        this.postService = postService;
    }

    @GetMapping("")
    public List<FriendGroupVO> getAllGroupsForUser(@RequestHeader("Authorization") String token) {
        String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        System.out.println("email: " + email);
        List<FriendGroup> userGroupList= groupService.getUserGroups(email);
        List<FriendGroupVO> userGroupListVO = new ArrayList<>();
        for (FriendGroup group : userGroupList) {
            System.out.println("group: " + group.getName());
            System.out.println("group id: " + group.getId());
            userGroupListVO.add(new FriendGroupVO(group.getId(), group.getName()));
        }
        return userGroupListVO;
    }


    @PostMapping("/create")
    public void createGroup(@RequestHeader("Authorization") String token, @RequestBody CreateGroupRequest request) {
        try {
            String jwt = token.substring(7);
            String email = jwtService.extractUsername(jwt);
            System.out.println("creating group with name: " + request.getGroupName());
            groupService.createGroup(request.getUserEmails(), request.getGroupName());
        } catch (Exception e) {
            System.out.println("Error creating group: " + e);
        }
    }

    @GetMapping("/{id}")
    public FriendGroupSingleVO getGroup(@PathVariable Long id) {
        FriendGroup group = groupService.getGroup(id);
        List<String> members = new ArrayList<>();
        for (User member : group.getMembers()) {
            members.add(member.getEmail());
        }
        List<Post> posts = postService.getPostsForGroup(id);
        FriendGroupSingleVO groupVO = new FriendGroupSingleVO(group.getId(), group.getName(), members, posts);
        return groupVO;
    }

//    Post post = new Post();

    @PostMapping("/{id}/add")
    public void addPost(@PathVariable Long id, @RequestBody AddPostRequest request) {
        try{
        postService.createPost(request.getTitle(), request.getContent(), request.getLocation(), request.getRating(), id);}
        catch (Exception e) {
            System.out.println("Error creating post: " + e);
            e.printStackTrace();
        }
    }

}
