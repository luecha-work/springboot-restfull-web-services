package luechawork.springbootrestfullwebservices.helloworld;

import luechawork.springbootrestfullwebservices.helloworld.model.MHelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController()
public class HelloController {

    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/get-hello-world")

    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/get-hello-world-bean")
    public MHelloWorldBean helloWorldBean() {
        return new MHelloWorldBean("Hello World");
    }

    //Path Parameters
    // /users/{id}/tools/{id} => /users/2/todos/200
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public MHelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new MHelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationlized")
    public String helloWorldInternationlized() {
        Locale locale = LocaleContextHolder.getLocale();

        return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);


        //1. good.morning.message
    }
}
