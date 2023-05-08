package springboot.Models.Dto;

import lombok.Data;
import springboot.Models.Request.UserRequest;
import springboot.Models.Response.UserResponse;

@Data
public class UserDto {
    private Long Id;
    private String name;
    private String lastname;

    private static UserDto fromRequestToDto(UserRequest userRequest){
        UserDto userDto = new UserDto();
        userDto.setName(userRequest.getName());
        userDto.setLastname(userDto.getLastname());
        return userDto;
    }

    private UserResponse fromDtoToResponse(){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(this.getId());
        userResponse.setLastname(this.getLastname());
        userResponse.setName(this.getName());
        return userResponse;
    }

}
