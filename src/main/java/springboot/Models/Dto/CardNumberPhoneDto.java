package springboot.Models.Dto;

import lombok.Data;
import springboot.Models.Request.CardNumberPhoneReqeust;
import springboot.Models.Response.CardNumberPhoneResponse;

@Data
public class CardNumberPhoneDto {

    private Long id;
    private int numberCard;

    private static CardNumberPhoneDto fromRequestToDto(CardNumberPhoneReqeust cardNumberPhoneReqeust){
        CardNumberPhoneDto cardNumberPhoneDto = new CardNumberPhoneDto();
        cardNumberPhoneDto.setNumberCard(cardNumberPhoneReqeust.getNumberCard());
        return cardNumberPhoneDto;
    }

    private CardNumberPhoneResponse fromDtoToResponse(){
        CardNumberPhoneResponse cardNumberPhoneResponse = new CardNumberPhoneResponse();
        cardNumberPhoneResponse.setId(this.getId());
        cardNumberPhoneResponse.setNumberCard(this.getNumberCard());
        return cardNumberPhoneResponse;
    }
}
