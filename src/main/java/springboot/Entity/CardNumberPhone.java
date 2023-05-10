package springboot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card_number")
public class CardNumberPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numberCard;

    @ManyToOne
    @JoinColumn(name = "phoneId")
    private  Phone phone;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User userPhones;
}
