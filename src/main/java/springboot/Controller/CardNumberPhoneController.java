package springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.Models.Dto.CardNumberPhoneDto;
import springboot.Models.Request.CardNumberPhoneReqeust;
import springboot.Models.Response.CardNumberPhoneResponse;
import springboot.Service.CardNumberPhoneService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CardNP")
@CrossOrigin("*")
public class CardNumberPhoneController {
    private CardNumberPhoneService cardNumberPhoneService;

    public CardNumberPhoneController(CardNumberPhoneService cardNumberPhoneService) {
        this.cardNumberPhoneService = cardNumberPhoneService;
    }

    @PostMapping("/save/{phoneId}")
    public ResponseEntity<CardNumberPhoneResponse> saveCardNumberPhone(@PathVariable Long phoneId, @RequestBody CardNumberPhoneReqeust cardNumberPhoneReqeust){
        CardNumberPhoneDto cardNumberPhoneDto = CardNumberPhoneDto.fromRequestToDto(cardNumberPhoneReqeust);
        CardNumberPhoneDto saveCardNumberPhone = cardNumberPhoneService.saveCardNumberPhone(phoneId,cardNumberPhoneDto);
        return ResponseEntity.ok(saveCardNumberPhone.fromDtoToResponse());
    }

    @GetMapping("/allCard")
    public ResponseEntity<List<CardNumberPhoneResponse>> allCardPhoneResponse(){
        List<CardNumberPhoneDto> cardNumberPhoneResponseList = cardNumberPhoneService.findAllCardNumberPhone();
        return ResponseEntity.ok(cardNumberPhoneResponseList.stream().map(CardNumberPhoneDto::fromDtoToResponse).collect(Collectors.toList()));
    }

   //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CardNumberPhoneResponse> deleteCard(@PathVariable Long id){
        return ResponseEntity.ok(cardNumberPhoneService.deleteCardNumberPhone(id).fromDtoToResponse());
    }
}
