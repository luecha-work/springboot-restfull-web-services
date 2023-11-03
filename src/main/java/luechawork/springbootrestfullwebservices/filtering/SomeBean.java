package luechawork.springbootrestfullwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"field1", "field2"})
public class SomeBean {
    private String field1;

    //    @JsonIgnore  //Not return
    private String field2;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
