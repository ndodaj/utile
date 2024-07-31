package al.utile.utile.dto;

import al.utile.utile_common.utile.StatusEnum;

public record RoleDto(Integer id, RoleEnum name, StatusEnum status, String description) {
}
