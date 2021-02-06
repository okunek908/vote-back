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

@MicronautTest(transactional = false)
public class HelloITest {
    @Inject
    HelloController controller;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testRest()  {
        HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, ()-> {
            HttpResponse<String> usersResponse = client.toBlocking()
                    .exchange(GET("/hello").basicAuth("Aladdin", "open sesame!"));
            System.out.println(usersResponse);

        });
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatus());
    }


    @Test
    void testHello() {
        Assertions.assertEquals(controller.getRoot(), "Vote Backend");
    }


}
