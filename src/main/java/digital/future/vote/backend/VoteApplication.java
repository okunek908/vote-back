package digital.future.vote.backend;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Vote",
                version = "1.0",
                description = "Vote API",
                //TODO: fill in contact if required
                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
                contact = @Contact(url = "http://something.com", name = "something", email = "something")
        )
)
public class VoteApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = Micronaut.build(args)
                // Fast-fail for debug (TODO: consider removing on prod)
                .eagerInitConfiguration(true)
                .eagerInitSingletons(true)
                .mainClass(VoteApplication.class)
        .start();

    }
}
