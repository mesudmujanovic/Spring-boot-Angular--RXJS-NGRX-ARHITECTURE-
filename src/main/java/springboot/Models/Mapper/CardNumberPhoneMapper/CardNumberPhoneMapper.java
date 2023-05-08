package springboot.Models.Mapper.CardNumberPhoneMapper;

import springboot.Entity.CardNumberPhone;
import springboot.Intergration.DTOmapper;
import springboot.Models.Dto.CardNumberPhoneDto;

public enum CardNumberPhoneMapper implements DTOmapper<CardNumberPhone, CardNumberPhoneDto> {
    INSTANCE;

    @Override
    public CardNumberPhone apply(CardNumberPhoneDto cardNumberPhoneDto) {
        CardNumberPhone cardNumberPhone = new CardNumberPhone();
        cardNumberPhone.setId(cardNumberPhoneDto.getId());
        cardNumberPhone.setNumberCard(cardNumberPhoneDto.getNumberCard());
        return cardNumberPhone;
    }
}
