package springboot.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.Entity.Image;

public interface ImageRepo extends JpaRepository<Image,Long> {
}
