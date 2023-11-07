package luechawork.springbootrestfullwebservices.entitys;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
//@JsonIgnoreProperties({"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;

    //    @JsonIgnore  //This column not return
    private String field2;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
