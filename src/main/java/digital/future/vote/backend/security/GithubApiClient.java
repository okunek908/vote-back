package digital.future.vote.backend.security;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Header(name = "Accept", value = "application/vnd.github.v3+json, application/json") //prefer v3
//@Client(id = "githubv3") //client id is mapped to url in configuration file
@Client("https://api.github.com")
public interface GithubApiClient {

    @Get("/user")
    Flowable<User> getUser(
            @Header(HttpHeaders.AUTHORIZATION) String authorization);
}
