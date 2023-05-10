package springboot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Entity.Phone;
import springboot.Models.Dto.PhoneDto;
import springboot.Models.Mapper.PhoneMapper.PhoneDtoMapper;
import springboot.Models.Mapper.PhoneMapper.PhoneMapper;
import springboot.Models.Mapper.UserMapper.UserMapper;
import springboot.Repository.PhoneRepo;
import springboot.Repository.UserRepo;
import springboot.Service.PhoneService;
import springboot.Service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneImpl implements PhoneService {

    public PhoneImpl(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @Autowired
    private  PhoneRepo phoneRepo;

    @Autowired
    private UserService userService;

    @Override
    public PhoneDto savePhone(PhoneDto phoneDto,Long userId ) {
        Phone phone = PhoneMapper.INSTANCE.apply(phoneDto);
        phone.setUser(UserMapper.INSTANCE.apply(userService.getUser(userId)));
        Phone phoneSave = phoneRepo.save(phone);
        return PhoneDtoMapper.INSTANCE.apply(phoneSave);
    }

    @Override
    public List<PhoneDto> getAllPhones() {
        List<Phone> phoneList = phoneRepo.findAll();
        return phoneList.stream().map(user -> PhoneDtoMapper.INSTANCE.apply(user)).collect(Collectors.toList());
    }

    @Override
    public PhoneDto deletePhone(Long id) {
        Phone phone = phoneRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        phoneRepo.deleteById(id);
        return PhoneDtoMapper.INSTANCE.apply(phone);
    }

    @Override
    public PhoneDto getPhone(Long id) {
        Phone phone = phoneRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        return PhoneDtoMapper.INSTANCE.apply(phone);
    }

    @Override
    public Phone getEntityPhone(Long id) {
        Phone phone = phoneRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return phone;
    }
}
