package springboot.Models.Dto;
import lombok.Data;
import springboot.Models.Request.PhoneRequest;
import springboot.Models.Response.PhoneResponse;

@Data
public class PhoneDto {
    private Long id;
    private String title;
    private String model;
    private byte[] image;

    public static PhoneDto fromRequestToDto (PhoneRequest phoneRequest){
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setTitle(phoneRequest.getTitle());
        phoneDto.setModel(phoneRequest.getModel());
        return phoneDto;
    }

    public PhoneResponse fromDtoToResponse (){
        PhoneResponse phoneResponse = new PhoneResponse();
        phoneResponse.setId(this.getId());
        phoneResponse.setModel(this.getModel());
        phoneResponse.setTitle(this.getTitle());
        return phoneResponse;
    }
}
