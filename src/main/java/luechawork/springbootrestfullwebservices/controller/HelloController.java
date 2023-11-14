package luechawork.springbootrestfullwebservices.controller;

import luechawork.springbootrestfullwebservices.models.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController()
public class HelloController {

    private final MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        super();
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/get-hello-world")

    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/get-hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    //Path Parameters
    // /users/{id}/tools/{id} => /users/2/todos/200
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();

        return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);


        //1. good.morning.message
    }
}
