package al.utile.utile.service;

import al.utile.utile.converter.UserConverter;
import al.utile.utile.entity.UserEntity;
import al.utile.utile.repository.UserRepository;
import al.utile.utile_rest_common.utile.UserDto;
import al.utile.utile_rest_common.utile.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

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

    public void registerUser(UserRegistrationDto userRegistrationDto) {
        userRepository.save(userConverter.toEntity(userRegistrationDto));
    }
}

