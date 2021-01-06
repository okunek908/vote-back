package digital.future.vote.backend;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class VoteApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = Micronaut.build(args)
                // Fast-fail for debug (TODO: remove on prod)
                .eagerInitConfiguration(true)
                .eagerInitSingletons(true)
                .mainClass(VoteApplication.class)
        .start();

    }
}
