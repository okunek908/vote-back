package digital.future.vote.backend;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(transactional = false)
public class HelloITest {
    @Inject
    HelloController controller;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testUnauth() {
        HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking()
                    .exchange(GET("/hello"));

        });
        assertEquals(HttpStatus.UNAUTHORIZED, e.getStatus());
    }

    @Test
    void testAuth() {
        HttpResponse<String> usersResponse = client.toBlocking()
                .exchange(GET("/hello").basicAuth("Aladdin", "open sesame"));
        assertEquals(HttpStatus.OK, usersResponse.getStatus());
    }


    @Test
    void testHello() {
        assertEquals(controller.getRoot(), "Vote Backend");
    }


}
