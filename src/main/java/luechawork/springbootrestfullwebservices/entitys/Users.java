package luechawork.springbootrestfullwebservices.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "user_details")
public class Users {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Name should have at lest 2 characters")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Brith Date should be in the past")
    @JsonProperty("brith_date")
    private LocalDate brithDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    protected Users() {
    }

    public Users(Integer id, String name, LocalDate brithDate) {
        setId(id);
        setName(name);
        setBrithDate(brithDate);
    }
}
