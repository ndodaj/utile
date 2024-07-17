package al.utile.utile;

import al.utile.utile.converter.RoleConverter;
import al.utile.utile.dto.RoleDto;
import al.utile.utile.entity.RoleEntity;
import al.utile.utile.repository.RoleRepository;
import al.utile.utile.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private RoleConverter roleConverter;

    @InjectMocks
    private RoleService roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRoleById() {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(1);
        RoleDto dto = new RoleDto(1, null, null, null);

        when(roleRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(roleConverter.toDto(entity)).thenReturn(dto);

        Optional<RoleDto> result = roleService.getRoleById(1L);
        assertEquals(Optional.of(dto), result);
    }

    // Add more tests for other service methods...
}
