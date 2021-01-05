package digital.future.vote.backend;

import io.micronaut.http.annotation.Controller;

@Controller()
public class DefaultController {
    public String getHome() {
        return "Hello, Micronaut!";
    }
}
