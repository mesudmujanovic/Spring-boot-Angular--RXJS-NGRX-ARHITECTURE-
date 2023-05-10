package springboot.Models.Response;
import lombok.Data;
import javax.persistence.Lob;

@Data
public class ImageResponse {
    private Long id;
    @Lob
    private byte[] image;
}
