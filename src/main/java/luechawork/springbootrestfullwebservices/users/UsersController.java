package luechawork.springbootrestfullwebservices.users;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import jakarta.validation.Valid;
import luechawork.springbootrestfullwebservices.exception.UserNotFoundException;
import luechawork.springbootrestfullwebservices.users.model.MUsers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UsersController {

    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<MUsers> retrieveAllUsers() {
        return userService.findAll();
    }

    //    EntityModel
    //    WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<MUsers> retrieveUser(@PathVariable int id) {
        MUsers user = userService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<MUsers> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder  link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<MUsers> createUser(@Valid @RequestBody MUsers user) {

        MUsers createdUser = this.userService.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
