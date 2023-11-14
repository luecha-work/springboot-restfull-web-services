package luechawork.springbootrestfullwebservices.models;

import lombok.Data;
import luechawork.springbootrestfullwebservices.models.Name;

@Data
public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }
}
