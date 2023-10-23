package luechawork.springbootrestfullwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UsersDaoService {

    //CRUD Users
    //JPA/Hibernate

    private static List<Users> users = new ArrayList<>();

    private  static int usersCount = 0;

    static {
        users.add(new Users(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new Users(++usersCount, "Eva", LocalDate.now().minusYears(25)));
        users.add(new Users(++usersCount, "Jim", LocalDate.now().minusYears(30)));
    }

    public List<Users> findAll() {
        return users;
    }

    public Users findOne(int id) {
        Predicate<? super Users> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(int id) {
        Predicate<? super Users> predicate = user -> user.getId().equals(id);

        users.removeIf(predicate);
    }

    public Users createUser(Users user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
