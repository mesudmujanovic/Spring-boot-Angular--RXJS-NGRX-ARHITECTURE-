package springboot.Service;

import springboot.Models.Dto.CardNumberPhoneDto;

import java.util.List;

public interface CardNumberPhoneService {

    public CardNumberPhoneDto saveCardNumberPhone (Long id,CardNumberPhoneDto cardNumberPhoneDto,Long userId);

    public List<CardNumberPhoneDto> findAllCardNumberPhone ();

    public CardNumberPhoneDto deleteCardNumberPhone(Long id);
}
