package al.utile.utile.controller;

import al.utile.utile.dto.RoleDto;
import al.utile.utile.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@Tag(name = "Roles", description = "Role management APIs")
public class RoleController {
    // http://localhost:8080/swagger-ui.html
    @Autowired
    private RoleService roleService;

    @GetMapping
    @Operation(summary = "Get all roles", description = "Retrieve a list of all roles")

    public List<RoleDto> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a role by ID", description = "Retrieve a role by their ID")

    public Optional<RoleDto> getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new role", description = "Add a new role to the system")

    public RoleDto createRole(@RequestBody RoleDto roleDTO) {
        return roleService.saveRole(roleDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a role", description = "Update an existing role by their ID")

    public RoleDto updateRole(@PathVariable Long id, @RequestBody RoleDto roleDetails) {
        return roleService.updateRole(id, roleDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a role", description = "Delete a role by their ID")

    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
