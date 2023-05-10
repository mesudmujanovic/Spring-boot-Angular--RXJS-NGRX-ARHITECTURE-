package springboot.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.Entity.Image;
import springboot.Repository.ImageRepo;
import springboot.Service.ImageService;
import springboot.Service.PhoneService;
import java.io.IOException;

@Service
public class ImageServiceImpl  implements ImageService {
    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    PhoneService phoneService;

    public String saveImage(MultipartFile file, Long id) throws IOException {
        Image image = new Image();
        image.setImage(file.getBytes());
        image.setPhoneImg(phoneService.getEntityPhone(id));
        imageRepo.save(image);
        return "Image saved";
    }
}
