package hack.movielink.controller;

import hack.movielink.domain.user.dto.FriendVO;
import hack.movielink.service.FriendsService;
import hack.movielink.service.auth.JwtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsController {

private final FriendsService friendsService;
private final JwtService jwtService;


    public FriendsController(FriendsService friendsService, JwtService jwtService) {
        this.friendsService = friendsService;
        this.jwtService = jwtService;
    }

    @GetMapping("")
    public List<FriendVO> getAllFriends(@RequestHeader("Authorization") String token) {
        // must get user from token
        String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        System.out.println("email: " + email);
        return friendsService.getFriends(email);
    }

    @PostMapping("/add")
    public void addFriend(@RequestHeader("Authorization") String token, @RequestBody AddFriendRequest request) {
        // must get user from token
        String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        System.out.println("email of friend to add: " + request.getFriendEmail());
        friendsService.addFriend(email, request.getFriendEmail());
    }
}

