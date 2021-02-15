package digital.future.vote.backend;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

// For testing purposes //TODO: remove on prod
@Controller("/")
public class HelloController {
    @Get("/hello")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public String getHome(Principal principal) {
        return "Hello, " + principal.getName();
    }

    @Get
    @Secured(SecurityRule.IS_ANONYMOUS)
    public String getRoot() {
        return "Vote Backend";
    }
}
