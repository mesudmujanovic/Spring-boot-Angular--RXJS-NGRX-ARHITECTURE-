package springboot.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.Entity.CardNumberPhone;
import springboot.Models.Dto.CardNumberPhoneDto;
import springboot.Models.Mapper.CardNumberPhoneMapper.CardNumberPhoneDtoMapper;
import springboot.Models.Mapper.CardNumberPhoneMapper.CardNumberPhoneMapper;
import springboot.Repository.CardNumberPhoneRepo;
import springboot.Service.CardNumberPhoneService;

import java.util.List;
import java.util.stream.Collectors;

public class CardNumberPhoneImpl implements CardNumberPhoneService {

    public CardNumberPhoneImpl(CardNumberPhoneRepo cardNumberPhoneRepo) {
        this.cardNumberPhoneRepo = cardNumberPhoneRepo;
    }

    @Autowired
    public CardNumberPhoneRepo cardNumberPhoneRepo;
    @Override
    public CardNumberPhoneDto saveCardNumberPhone(CardNumberPhoneDto cardNumberPhoneDto) {
        CardNumberPhone cardNumberPhone = CardNumberPhoneMapper.INSTANCE.apply(cardNumberPhoneDto);
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
