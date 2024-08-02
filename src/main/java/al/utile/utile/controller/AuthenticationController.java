package al.utile.utile.controller;


import al.utile.utile.dto.AuthenticationRequest;
import al.utile.utile.service.UserService;
import al.utile.utile_common.utile.dto.AuthenticationResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse loadUserByCredentials(
            @RequestBody AuthenticationRequest authenticationRequest) throws UsernameNotFoundException {
        return userService.loadUserByCredentials(authenticationRequest);
    }

}
