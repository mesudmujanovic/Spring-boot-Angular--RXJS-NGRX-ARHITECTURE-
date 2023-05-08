package springboot.Service;
import springboot.Models.Dto.PhoneDto;
import java.util.List;

public interface PhoneService {

    public PhoneDto savePhone(PhoneDto phoneDto);

    public List<PhoneDto> getAllPhones();

    public PhoneDto deletePhone(Long id);
}
