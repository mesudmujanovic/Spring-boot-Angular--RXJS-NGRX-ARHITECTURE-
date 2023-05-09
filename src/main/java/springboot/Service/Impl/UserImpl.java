package springboot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Entity.User;
import springboot.Models.Dto.UserDto;
import springboot.Models.Mapper.UserMapper.UserDtoMapper;
import springboot.Models.Mapper.UserMapper.UserMapper;
import springboot.Repository.UserRepo;
import springboot.Service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDto saveUser(UserDto userDto) {
        //Pretvaranje entity u Dto preko Mappera
        User user = UserMapper.INSTANCE.apply(userDto);
        User userSave = userRepo.save(user);
        //pretvaramo sacuvanog usera(entity) u Dto preko Mappera
        return UserDtoMapper.INSTANCE.apply(userSave);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepo.findAll();
        //vracamo userList i prolazimo kroz svaki user i svaki pronadjeni user pretvaramo u dto preko userDtoMappera i stavljamo sve u list(toList)
        return userList.stream().map(user-> UserDtoMapper.INSTANCE.apply(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        userRepo.deleteById(id);
        return UserDtoMapper.INSTANCE.apply(user);
    }
}
