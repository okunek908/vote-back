package digital.future.vote.backend;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class HelloTest {
    @Inject
    HelloController controller;

    @Test
    void testHello() {
        Assertions.assertEquals(controller.getRoot(), "Vote Backend");
    }
}
