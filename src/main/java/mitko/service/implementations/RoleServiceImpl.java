package mitko.service.implementations;

import mitko.dto.RoleDto;
import mitko.model.Role;
import mitko.repository.RoleRepository;
import mitko.service.RoleService;
import mitko.util.RoleConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> getRole() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role role : roles) {
            roleDtos.add(RoleConverter.toRoleDto(role));
        }
        return roleDtos;
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        Role role = RoleConverter.toRoleEntity(roleDto);
        roleRepository.save(role);
        return RoleConverter.toRoleDto(role);
    }

    @Override
    public RoleDto update(long id, RoleDto roleDto) {
        Role role = RoleConverter.toRoleEntity(roleDto);
        role.setId(id);
        return RoleConverter.toRoleDto(roleRepository.save(role));
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}
