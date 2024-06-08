package hack.movielink.controller;

import hack.movielink.service.auth.JwtService;
import hack.movielink.service.auth.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final JwtService jwtService;
    private final UserService userService;

    public ProfileController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/picture")
    public void updateProfilePicture(@RequestHeader("Authorization") String token, @RequestBody String picture) {
        String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        userService.setProfilePicture(email, picture);
    }


}
