package al.utile.utile.service;

import al.utile.utile.converter.UserConverter;
import al.utile.utile.dto.AuthenticationRequest;
import al.utile.utile.entity.UserEntity;
import al.utile.utile.repository.UserRepository;
import al.utile.utile_common.utile.AuthenticationResponse;
import al.utile.utile_common.utile.UserDto;
import al.utile.utile_common.utile.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userConverter::toDto).collect(Collectors.toList());
    }

    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id).map(userConverter::toDto);
    }

    public UserDto saveUser(UserDto UserDto) {
        UserEntity entity = userConverter.toEntity(UserDto);
        UserEntity savedEntity = userRepository.save(entity);
        return userConverter.toDto(savedEntity);
    }

    public UserDto updateUser(Long id, UserDto userDetails) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        entity.setUsername(userDetails.username());
        // update other fields later
        UserEntity updatedUser = userRepository.save(entity);
        return userConverter.toDto(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void registerUser(@Valid UserRegistrationDto userRegistrationDto) {
        userRepository.save(userConverter.toEntity(userRegistrationDto));
    }

    public AuthenticationResponse loadUserByCredentials(AuthenticationRequest authenticationRequest) {
        UserEntity userEntity = userRepository.findByUsername(authenticationRequest.username())
                .orElseThrow(() -> new BadCredentialsException("User ot found"));
        if(!bCryptPasswordEncoder.matches(authenticationRequest.password(), userEntity.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
        List<String> roles = new ArrayList<>();
        userEntity.getRoles().forEach(role -> roles.add(role.getName().name()));
        return new AuthenticationResponse(authenticationRequest.username(), roles);




    }
}

