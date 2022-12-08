package sk.balaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/greet")
    public GreetRespone greet() {
        return new GreetRespone(
                "Hello",
                List.of("Java", "Python"),
                new Person("Tomas", 30, 30_000));
    }

    record Person(
            String name,
            int age,
            double savings
    ) {}

    record GreetRespone(
            String greet,
            List<String> favouriteProgrammingLanguages,
            Person person) {}
}
