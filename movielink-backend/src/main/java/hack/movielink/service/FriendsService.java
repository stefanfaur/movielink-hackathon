package hack.movielink.service;

import hack.movielink.domain.user.dto.FriendVO;
import hack.movielink.domain.user.entity.User;
import hack.movielink.domain.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {

    // we're calling this friends service to separate concerns
    // but in essence it is just a friends-focused user service
    private final UserJpaRepository userRepository;

    public FriendsService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addFriend(String userEmail, String friendEmail) {
        try {
            User user = userRepository.findByEmail(userEmail).orElseThrow();
            System.out.println("found user: " + user.getEmail());
            User friend = userRepository.findByEmail(friendEmail).orElseThrow();
            System.out.println("found friend: " + friend.getEmail());
            user.getFriends().add(friend); // must add both ways
            friend.getFriends().add(user);
            userRepository.save(user);
            System.out.println("added friend " + friendEmail + " to " + userEmail);
        } catch (Exception e) {
            System.out.println("Error adding friend: " + e);
        }
    }

    public void removeFriend(String userEmail, String friendEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        User friend = userRepository.findByEmail(friendEmail).orElseThrow();
        user.getFriends().remove(friend); // must remove both ways
        friend.getFriends().remove(user);
        userRepository.save(user);
    }

    public List<FriendVO> getFriends(String email) {
        List<User> friendUserList = userRepository.findByEmail(email).orElseThrow().getFriends();
        return friendUserList.stream()
                .map(friend -> new FriendVO(friend.getEmail(), friend.getFullName(), friend.getProfilePicture()))
                .toList();
    }

}
