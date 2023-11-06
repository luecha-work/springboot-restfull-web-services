package luechawork.springbootrestfullwebservices.users;

import luechawork.springbootrestfullwebservices.model.MUsers;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UsersService {

    //CRUD Users
    //JPA/Hibernate

    private static List<MUsers> users = new ArrayList<>();

    private  static int usersCount = 0;

    static {
        users.add(new MUsers(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new MUsers(++usersCount, "Eva", LocalDate.now().minusYears(25)));
        users.add(new MUsers(++usersCount, "Jim", LocalDate.now().minusYears(30)));
    }

    public List<MUsers> findAll() {
        return users;
    }

    public MUsers findOne(int id) {
        Predicate<? super MUsers> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(int id) {
        Predicate<? super MUsers> predicate = user -> user.getId().equals(id);

        users.removeIf(predicate);
    }

    public MUsers createUser(MUsers user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
