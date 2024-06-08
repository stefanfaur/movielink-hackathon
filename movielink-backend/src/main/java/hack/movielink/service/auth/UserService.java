package hack.movielink.service.auth;

import hack.movielink.domain.user.entity.User;
import hack.movielink.domain.user.repository.UserJpaRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public void saveTestUser(String fullName, String email, String password) {
        User user = new User(fullName, password, email);
        userJpaRepository.save(user);
    }


    public void setProfilePicture(String email, String picture) {
        User user = userJpaRepository.findByEmail(email).orElseThrow();
        user.setProfilePicture(picture);
        userJpaRepository.save(user);
    }
}
