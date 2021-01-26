package digital.future.vote.backend;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.BootstrapContextCompatible;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.jackson.JacksonConfiguration;
import io.micronaut.jackson.ObjectMapperFactory;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import javax.inject.Singleton;
import java.util.Optional;

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
