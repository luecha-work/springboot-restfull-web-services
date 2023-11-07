package luechawork.springbootrestfullwebservices.repository;

import luechawork.springbootrestfullwebservices.entitys.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
