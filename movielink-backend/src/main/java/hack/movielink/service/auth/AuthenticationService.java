package hack.movielink.service.auth;

import hack.movielink.domain.user.dto.UserLoginDTO;
import hack.movielink.domain.user.dto.UserRegisterDTO;
import hack.movielink.domain.user.entity.User;
import hack.movielink.domain.user.repository.UserJpaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    private final UserJpaRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationService(
            UserJpaRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.saveTestUser("Test Popescu", "test@test.com", passwordEncoder.encode("test12345"));
        userService.saveTestUser("Test Ionescu", "ceva@ceva.com", passwordEncoder.encode("test12345"));
        userService.saveTestUser("string", "string", passwordEncoder.encode("test12345"));
    }

    public User signup(UserRegisterDTO input) {
        User user = new User(
                input.fullName(),
                passwordEncoder.encode(input.password()),
                input.email());
        return userRepository.save(user);
    }

    public User authenticate(UserLoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }

}
