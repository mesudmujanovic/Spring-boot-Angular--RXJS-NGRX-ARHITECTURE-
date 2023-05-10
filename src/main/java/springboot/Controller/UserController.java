package springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.Models.Dto.UserDto;
import springboot.Models.Request.UserRequest;
import springboot.Models.Response.UserResponse;
import springboot.Service.UserService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest){
        //userRequest u Dto preko funkcije koju smo napravili u ModelsDTO, pretvaranje requesta u dto
        UserDto newUserDto = UserDto.fromRequestToDto(userRequest);
        UserDto saveUserDto = userService.saveUser(newUserDto);
        //iz dto u resposne jer i saljemo <UserResponse>
        return ResponseEntity.ok(saveUserDto.fromDtoToResponse());
    }

    @GetMapping("/allposts")
    public ResponseEntity <List<UserResponse>> getAllUser(){
        List<UserDto> userDtoList = userService.getAllUsers();
        //vracamo listu kroz koju smo prosli za svaki post i vracamo Response preko  fromDtoToResponse;
        return ResponseEntity.ok(userDtoList.stream().map(UserDto::fromDtoToResponse).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id).fromDtoToResponse());
    }
}
