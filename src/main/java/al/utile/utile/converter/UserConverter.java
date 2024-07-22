package al.utile.utile.converter;

import al.utile.utile.entity.UserEntity;
import al.utile.utile_rest_common.utile.UserDto;
import al.utile.utile_rest_common.utile.UserRegistrationDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity toEntity(UserRegistrationDto userRegistrationDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userRegistrationDto.username());
        entity.setEmail(userRegistrationDto.email());
        entity.setFirstName(userRegistrationDto.firstName());
        entity.setLastName(userRegistrationDto.lastName());
        entity.setBirthday(userRegistrationDto.birthday());
        entity.setMobilePhone(userRegistrationDto.mobilePhone());
        entity.setAddress(userRegistrationDto.address());
        entity.setPassword(userRegistrationDto.password());
        entity.setAccountType(userRegistrationDto.accountType());
        return entity;
    }

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
