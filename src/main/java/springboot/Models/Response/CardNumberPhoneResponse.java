package springboot.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardNumberPhoneResponse {
    private Long id;
    private int numberCard;
}
