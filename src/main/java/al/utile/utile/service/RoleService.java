package al.utile.utile.service;

import al.utile.utile.converter.RoleConverter;
import al.utile.utile.dto.RoleDto;
import al.utile.utile.entity.RoleEntity;
import al.utile.utile.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleConverter::toDto)
                .collect(Collectors.toList());
    }

    public Optional<RoleDto> getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleConverter::toDto);
    }

    public RoleDto saveRole(RoleDto RoleDto) {
        RoleEntity role = roleConverter.toEntity(RoleDto);
        RoleEntity savedRole = roleRepository.save(role);
        return roleConverter.toDto(savedRole);
    }

    public RoleDto updateRole(Long id, RoleDto roleDetails) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(roleDetails.name());
        RoleEntity updatedRole = roleRepository.save(role);
        return roleConverter.toDto(updatedRole);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}


