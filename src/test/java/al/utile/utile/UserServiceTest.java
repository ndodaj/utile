package al.utile.utile;

import al.utile.utile.converter.UserConverter;
import al.utile.utile.entity.UserEntity;
import al.utile.utile.repository.UserRepository;
import al.utile.utile.service.UserService;
import al.utile.utile_rest_common.utile.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        UserDto dto = new UserDto(1, null);
        UserEntity entity = new UserEntity();
        entity.setUserId(1);

        when(userRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(userConverter.toDto(entity)).thenReturn(dto);

        Optional<UserDto> result = userService.getUserById(1L);
        assertEquals(Optional.of(dto), result);
    }

    // Add more tests for other service methods...
}
