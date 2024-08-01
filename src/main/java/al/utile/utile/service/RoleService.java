package al.utile.utile.service;

import al.utile.utile.converter.RoleConverter;
import al.utile.utile.dto.RoleDto;
import al.utile.utile.entity.RoleEntity;
import al.utile.utile.repository.RoleRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleConverter roleConverter;

    public RoleService(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }

    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleConverter::toDto)
                .toList();
    }

    public Optional<RoleDto> getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleConverter::toDto);
    }

    public RoleDto saveRole(RoleDto roleDto) {
        RoleEntity role = roleConverter.toEntity(roleDto);
        RoleEntity savedRole = roleRepository.save(role);
        return roleConverter.toDto(savedRole);
    }

    public RoleDto updateRole(Long id, RoleDto roleDetails) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role not found"));
        role.setName(roleDetails.name());
        RoleEntity updatedRole = roleRepository.save(role);
        return roleConverter.toDto(updatedRole);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}


