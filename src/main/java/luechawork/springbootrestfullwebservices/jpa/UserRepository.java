package luechawork.springbootrestfullwebservices.jpa;

import luechawork.springbootrestfullwebservices.model.MUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MUsers, Integer> {
}
