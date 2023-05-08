package springboot.Models.Mapper.UserMapper;

import springboot.Entity.User;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.UserDto;

public enum UserMapper implements DTOmapper<User, UserDto> {
    INSTANCE;
    @Override
    public User apply(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        return user;
    }
}
