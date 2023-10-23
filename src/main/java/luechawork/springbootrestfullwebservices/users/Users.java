package luechawork.springbootrestfullwebservices.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Users {
    public Users(Integer id, String name, LocalDate brithDate) {
        setId(id);
        setName(name);
        setBrithDate(brithDate);
    }

    private Integer id;

    @Size(min = 2 , message = "Name should have at lest 2 characters")
    private String name;

    @Past(message = "Brith Date should be in the past")
    private LocalDate brithDate;
}
