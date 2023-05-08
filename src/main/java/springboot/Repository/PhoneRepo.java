package springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.Entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone,Long> {
}
