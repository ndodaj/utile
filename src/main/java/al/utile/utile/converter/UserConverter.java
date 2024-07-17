package al.utile.utile.converter;

import al.utile.utile.dto.UserDto;
import al.utile.utile.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto toDto(UserEntity entity) {
        return new UserDto(
                entity.getUserId(),
                entity.getUsername()
        );
    }

    public UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.id());
        entity.setUsername(dto.username());
        return entity;
    }
}
