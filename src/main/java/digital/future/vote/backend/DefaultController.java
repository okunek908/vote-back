package digital.future.vote.backend;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller()
public class DefaultController {
    @Get
    public String getHome() {
        return "Hello, Micronaut!";
    }
}
