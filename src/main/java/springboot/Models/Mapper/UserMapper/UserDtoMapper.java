package springboot.Models.Mapper.UserMapper;

import springboot.Entity.User;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.UserDto;

public class UserDtoMapper implements DTOmapper<UserDtoMapper, User> {
    @Override
    public UserDto apply(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        user.setName(user.getName());
        user.setLastname(user.getLastname());
        return userDto;
    }
}
