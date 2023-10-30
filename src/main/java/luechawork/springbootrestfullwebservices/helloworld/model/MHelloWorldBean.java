package luechawork.springbootrestfullwebservices.helloworld.model;

import lombok.Data;

@Data
public class MHelloWorldBean {

    private String massage;

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "massage='" + massage + '\'' +
                '}';
    }

    public MHelloWorldBean(String message){
        setMassage(message);
    }
}
