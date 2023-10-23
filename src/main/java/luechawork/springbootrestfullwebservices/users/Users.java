package luechawork.springbootrestfullwebservices.users;

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
    private String name;
    private LocalDate brithDate;
}
