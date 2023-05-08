package springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.Entity.User;

public interface UserRepo extends JpaRepository<User,Long> {
}
