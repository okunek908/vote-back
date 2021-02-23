package digital.future.vote.backend.security;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("https://login.microsoftonline.com/common/oauth2/v2.0/token")
public interface MicrosoftTokenApiClient {
    @Post(consumes = MediaType.APPLICATION_FORM_URLENCODED)
    Single<User> exchangeCodeForToken(@Body
            @Header(HttpHeaders.AUTHORIZATION) String authorization);
}
