package al.utile.utile.controller;


import al.utile.utile.dto.AuthenticationRequest;
import al.utile.utile.service.UserService;
import al.utile.utile_common.utile.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public AuthenticationResponse loadUserByCredentials(
            @RequestBody AuthenticationRequest authenticationRequest) throws UsernameNotFoundException {
        return userService.loadUserByCredentials(authenticationRequest);
    }

}
