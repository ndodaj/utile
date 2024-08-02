package al.utile.utile.converter;

import al.utile.utile.entity.RoleEntity;
import al.utile.utile_common.utile.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public RoleDto toDto(RoleEntity entity) {
        return new RoleDto(
                entity.getName(),
                entity.getStatus(),
                entity.getDescription()
        );
    }

    public RoleEntity toEntity(RoleDto dto) {
        RoleEntity entity = new RoleEntity();
        entity.setName(dto.name());
        entity.setStatus(dto.status());
        entity.setDescription(dto.description());
        return entity;
    }
}
