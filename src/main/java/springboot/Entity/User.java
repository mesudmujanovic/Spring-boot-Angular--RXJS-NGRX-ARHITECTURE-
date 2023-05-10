package springboot.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String lastname;

//    user ima vise telefona a telefon ima vise brojeva a vise brojeva ima jednog usera a phone ima vise slika
//    user OneToMany phone
//    phone ManyToOne user
//    phone OneToMany cardnumber
//    cardNumber manyToOne user
//    image ManyToOne

     @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
     private List<User> user;

     @OneToMany(mappedBy = "userPhones", fetch = FetchType.LAZY)
     private List<User> userPhones;
}
