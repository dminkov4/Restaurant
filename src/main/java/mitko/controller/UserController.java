package mitko.controller;

import mitko.dto.UserDto;
import mitko.model.User;
import mitko.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/role")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUser()  {
        return userService.getUser();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) throws SQLException {
        return userService.create(userDto);
    }

    @RequestMapping("/{id}")
    public User role(@PathVariable("id") int id) {
        return (User) userService.getUser();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UserDto updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }
}
