package luechawork.springbootrestfullwebservices.models;

import lombok.Data;

@Data
public class HelloWorldBean {

    private String massage;

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "massage='" + massage + '\'' +
                '}';
    }

    public HelloWorldBean(String message){
        setMassage(message);
    }
}
