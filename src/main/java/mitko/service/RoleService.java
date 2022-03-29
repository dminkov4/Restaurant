package mitko.service;

import mitko.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> getRole();
    RoleDto create(RoleDto roleDto);
    RoleDto update(long id, RoleDto roleDto);
    void delete(long id);
}
