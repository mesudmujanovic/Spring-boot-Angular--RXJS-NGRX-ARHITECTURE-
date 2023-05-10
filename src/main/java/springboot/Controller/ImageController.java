package springboot.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.Service.Impl.ImageServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("/imageOrFile")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping("/save/{phoneId}")
    public String saveImageOrFile(@RequestParam("file")MultipartFile file,
                                  @PathVariable Long phoneId) throws IOException {
        return imageService.saveImage(file,phoneId);
    }
}
