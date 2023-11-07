package luechawork.springbootrestfullwebservices.repository;

import luechawork.springbootrestfullwebservices.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
