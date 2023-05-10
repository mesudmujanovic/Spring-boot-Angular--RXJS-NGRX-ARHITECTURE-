package springboot.Models.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import springboot.Entity.Image;
import springboot.Models.Request.ImageRequest;
import springboot.Models.Response.ImageResponse;

import javax.persistence.Lob;
import java.io.IOException;

@Data
public class ImageDto {

    private Long id;
    @Lob
    private byte[] image;

    public static ImageDto fromRequestToDto(ImageRequest imageRequest, MultipartFile file) throws IOException {
        ImageDto imageDto = new ImageDto();
        imageDto.setImage(file.getBytes());
        return imageDto;
    }

    public ImageResponse fromDtoToRequest(){
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setId(this.getId());
        imageResponse.setImage(this.getImage());
        return imageResponse;
    }
}
