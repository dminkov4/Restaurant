package mitko.service.implementations;

import mitko.dto.UserDto;
import mitko.model.User;
import mitko.repository.UserRepository;
import mitko.service.UserService;
import mitko.util.UserConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserConverter.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = UserConverter.toUserEntity(userDto);
        userRepository.save(user);
        return UserConverter.toUserDto(user);
    }

    @Override
    public UserDto update(long id, UserDto userDto) {
        User user = UserConverter.toUserEntity(userDto);
        user.setId(id);
        return UserConverter.toUserDto(userRepository.save(user));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
