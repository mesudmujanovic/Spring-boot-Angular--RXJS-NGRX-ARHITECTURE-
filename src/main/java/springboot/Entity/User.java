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

//    user ima vise telefona a telefon ima vise brojeva a broj ima jednog usera
//    user onetomany phone
//    phone manytoone user
//    phone onetomany cardnumber
//    cardNumber onetoone user

     @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
     private List<User> user;

}
