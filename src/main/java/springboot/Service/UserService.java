package springboot.Service;

import springboot.Entity.User;
import springboot.Models.Dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto saveUser (UserDto userDto);
    public List<UserDto> getAllUsers();
    public UserDto deleteUser(Long id);
}
