package springboot.Models.Mapper.UserMapper;

import springboot.Entity.User;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.UserDto;

public enum UserDtoMapper implements DTOmapper<UserDtoMapper, User> {
    INSTANCE;
    @Override
    public UserDto apply(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        return userDto;
    }
}
