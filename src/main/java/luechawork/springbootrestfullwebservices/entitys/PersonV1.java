package luechawork.springbootrestfullwebservices.entitys;

import lombok.Data;

@Data
public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }
}