package digital.future.vote.backend;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

// For testing purposes
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/hello")
public class HelloController {
    @Get
    public String getHome(Principal principal) {
        return "Hello, " + principal.getName();
    }
}
