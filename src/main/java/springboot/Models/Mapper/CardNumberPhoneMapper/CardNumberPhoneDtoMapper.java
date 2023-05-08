package springboot.Models.Mapper.CardNumberPhoneMapper;

import springboot.Entity.CardNumberPhone;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.CardNumberPhoneDto;

public enum CardNumberPhoneDtoMapper implements DTOmapper<CardNumberPhoneDto, CardNumberPhone> {
    INSTANCE;

    @Override
    public CardNumberPhoneDto apply(CardNumberPhone cardNumberPhone) {
        CardNumberPhoneDto cardNumberPhoneDto = new CardNumberPhoneDto();
        cardNumberPhoneDto.setId(cardNumberPhone.getId());
        cardNumberPhoneDto.setNumberCard(cardNumberPhone.getNumberCard());
        return cardNumberPhoneDto;
    }
}
