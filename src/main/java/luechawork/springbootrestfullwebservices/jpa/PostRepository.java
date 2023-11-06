package luechawork.springbootrestfullwebservices.jpa;

import luechawork.springbootrestfullwebservices.model.MPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<MPost, Integer> {
}
