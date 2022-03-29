package mitko.service;

import mitko.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUser();
    UserDto create(UserDto userDto);
    UserDto update(long id, UserDto userDto);
    void delete(long id);
}
