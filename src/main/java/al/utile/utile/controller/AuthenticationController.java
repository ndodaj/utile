package al.utile.utile.controller;


import al.utile.utile.dto.AuthenticationRequest;
import al.utile.utile.security.JwtUtil;
import al.utile.utile.service.CustomUserDetailsService;
import al.utile.utile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

//    @PostMapping("/authenticate") // this should no longer exist
//    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password())
//        );
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username());
//        return jwtUtil.generateToken(userDetails.getUsername());
//    }

    @PostMapping("/authenticate")
    public UserDetails loadUserByCredentials(@RequestBody AuthenticationRequest authenticationRequest) throws UsernameNotFoundException {
        return userService.loadUserByCredentials(authenticationRequest);
    }

}
