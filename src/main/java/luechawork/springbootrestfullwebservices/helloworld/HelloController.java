package luechawork.springbootrestfullwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {

    @GetMapping(path = "/get-hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/get-hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World") ;
    }

    //Path Parameters
    // /users/{id}/tools/{id} => /users/2/todos/200
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
