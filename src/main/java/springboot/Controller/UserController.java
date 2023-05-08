package springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.Models.Dto.UserDto;
import springboot.Models.Request.UserRequest;
import springboot.Models.Response.UserResponse;
import springboot.Service.UserService;

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
        UserDto newUserDto = UserDto.fromRequestToDto(userRequest);
        UserDto saveUserDto = userService.saveUser(newUserDto);
        return ResponseEntity.ok(saveUserDto.fromDtoToResponse());
    }
}
