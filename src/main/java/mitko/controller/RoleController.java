package mitko.controller;

import mitko.dto.RoleDto;
import mitko.model.Role;
import mitko.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDto> getRole()  {
        return roleService.getRole();
    }

    @PostMapping
    public RoleDto createRole(@RequestBody RoleDto roleDto) throws SQLException {
        return roleService.create(roleDto);
    }

    @RequestMapping("/{id}")
    public Role role(@PathVariable("id") int id) {
        return (Role) roleService.getRole();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public RoleDto updateRole(@PathVariable("id") long id, @RequestBody RoleDto roleDto) {
        return roleService.update(id, roleDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        roleService.delete(id);
    }
}
