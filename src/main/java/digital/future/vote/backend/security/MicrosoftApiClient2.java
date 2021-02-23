package digital.future.vote.backend.security;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Client("https://graph.microsoft.com")
public interface MicrosoftApiClient2 {
    @Get("/v1.0/me222")
    Single<User> getUser(
            @Header(HttpHeaders.AUTHORIZATION) String authorization);

}
