package luechawork.springbootrestfullwebservices.users;

import jakarta.validation.Valid;
import luechawork.springbootrestfullwebservices.exception.UserNotFoundException;
import luechawork.springbootrestfullwebservices.jpa.PostRepository;
import luechawork.springbootrestfullwebservices.jpa.UserRepository;
import luechawork.springbootrestfullwebservices.model.MPost;
import luechawork.springbootrestfullwebservices.model.MUsers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UsersJpaController {

    private final UsersService userService;
    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public UsersJpaController(UsersService userService, UserRepository userRepository, PostRepository postRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<MUsers> retrieveAllUsers() {
        return userRepository.findAll();
    }

    //    EntityModel
    //    WebMvcLinkBuilder
    @GetMapping("/jpa/users/{id}")
    public EntityModel<MUsers> retrieveUser(@PathVariable int id) {
        Optional<MUsers> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<MUsers> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<MPost> retrievePostsForUser(@PathVariable int id) {
        Optional<MUsers> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }


        return user.get().getPosts();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<MUsers> createUser(@Valid @RequestBody MUsers user) {

        MUsers createdUser = this.userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Objects> createPostsForUser(@PathVariable int id, @Valid @RequestBody MPost post) {
        Optional<MUsers> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        post.setUser(user.get());
        MPost savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
