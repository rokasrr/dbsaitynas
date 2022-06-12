package lt.rokas.db.kirneilio.repository;

import lt.rokas.db.kirneilio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}