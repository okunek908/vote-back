package digital.future.vote.backend.security;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Singleton
public class MicrosoftApiClient {
    private final RxHttpClient httpClient;
    private final URI uri;

    public MicrosoftApiClient() throws MalformedURLException {
        httpClient = RxHttpClient.create(new URL("https://graph.microsoft.com"));
        uri = UriBuilder.of("/v1.0/me").build();
    }

    Single<User> getUser(String authorization) {
        MutableHttpRequest<?> req = HttpRequest.GET(uri);
        req.bearerAuth(authorization);
        Flowable<User> flowable = httpClient.retrieve(req, Argument.of(User.class));
        return flowable.singleOrError();
    }
}
