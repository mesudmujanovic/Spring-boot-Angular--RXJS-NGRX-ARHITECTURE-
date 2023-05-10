package springboot.Models.Request;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class ImageRequest {
    @Lob
    private byte[] image;
}
