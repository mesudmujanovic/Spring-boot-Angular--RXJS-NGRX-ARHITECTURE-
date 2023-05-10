package springboot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Entity.CardNumberPhone;
import springboot.Models.Dto.CardNumberPhoneDto;
import springboot.Models.Mapper.CardNumberPhoneMapper.CardNumberPhoneDtoMapper;
import springboot.Models.Mapper.CardNumberPhoneMapper.CardNumberPhoneMapper;
import springboot.Models.Mapper.PhoneMapper.PhoneMapper;
import springboot.Models.Mapper.UserMapper.UserMapper;
import springboot.Repository.CardNumberPhoneRepo;
import springboot.Service.CardNumberPhoneService;
import springboot.Service.PhoneService;
import springboot.Service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardNumberPhoneImpl implements CardNumberPhoneService {

    @Autowired
    public CardNumberPhoneRepo cardNumberPhoneRepo;
    public CardNumberPhoneImpl(CardNumberPhoneRepo cardNumberPhoneRepo) {
        this.cardNumberPhoneRepo = cardNumberPhoneRepo;
    }

    @Autowired
    public PhoneService phoneService;

    @Autowired
    public UserService userService;

    @Override
    public CardNumberPhoneDto saveCardNumberPhone(Long phoneId, CardNumberPhoneDto cardNumberPhoneDto,Long userId) {
        CardNumberPhone cardNumberPhone = CardNumberPhoneMapper.INSTANCE.apply(cardNumberPhoneDto);
        cardNumberPhone.setPhone(PhoneMapper.INSTANCE.apply(phoneService.getPhone(phoneId)));
        cardNumberPhone.setUserPhones(UserMapper.INSTANCE.apply(userService.getUser(userId)));
        CardNumberPhone saveCardNumberPhone = cardNumberPhoneRepo.save(cardNumberPhone);
        return CardNumberPhoneDtoMapper.INSTANCE.apply(saveCardNumberPhone);
    }

    @Override
    public List<CardNumberPhoneDto> findAllCardNumberPhone() {
        return cardNumberPhoneRepo.findAll().stream().map(card->
                CardNumberPhoneDtoMapper.INSTANCE.apply(card))
                .collect(Collectors.toList());
    }

    @Override
    public CardNumberPhoneDto deleteCardNumberPhone(Long id) {
        CardNumberPhone cardNumberPhone = cardNumberPhoneRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        cardNumberPhoneRepo.deleteById(id);
        return CardNumberPhoneDtoMapper.INSTANCE.apply(cardNumberPhone);
    }
}
