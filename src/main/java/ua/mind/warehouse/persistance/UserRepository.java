package ua.mind.warehouse.persistance;

/**
 * Created by Сергій on 10.09.14.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import ua.mind.warehouse.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
