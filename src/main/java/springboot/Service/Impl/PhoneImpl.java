package springboot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.Entity.Phone;
import springboot.Models.Dto.PhoneDto;
import springboot.Models.Mapper.PhoneMapper.PhoneDtoMapper;
import springboot.Models.Mapper.PhoneMapper.PhoneMapper;
import springboot.Repository.PhoneRepo;
import springboot.Service.PhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneImpl implements PhoneService {

    public PhoneImpl(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @Autowired
    PhoneRepo phoneRepo;

    @Override
    public PhoneDto savePhone(PhoneDto phoneDto) {
        Phone phone = PhoneMapper.INSTANCE.apply(phoneDto);
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
}
