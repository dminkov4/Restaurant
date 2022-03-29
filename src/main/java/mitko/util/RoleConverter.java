package mitko.util;

import mitko.dto.RoleDto;
import mitko.model.Role;

public class RoleConverter {

    private RoleConverter() {
    }

    /**
     * 	     * Converts role entity object to role DTO object.
     * 	     *
     * 	     * @param roleEntity source object of type {@link Role}
     * 	     * @return Role DTO converted from the source role Entity object.
     *
     */
    public static RoleDto toRoleDto(Role roleEntity) {
        RoleDto roleDTOToReturn = new RoleDto();
        roleDTOToReturn.setId(roleEntity.getId());
        roleDTOToReturn.setName(roleEntity.getName());
        return roleDTOToReturn;
    }

    /**
     * 	     * Converts role DTO object to role entity object.
     * 	     *
     * 	     * @param roleDTO    source object of type {@link RoleDto}
     * 	     * @return Role Entity converted from the source role DTO object.
     *
     */
    public static Role toRoleEntity(RoleDto roleDTO) {
        Role roleToReturn = new Role();
        roleToReturn.setName(roleDTO.getName());
        return roleToReturn;
    }
}

