package digital.future.vote.backend.security;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;

@Secured(SecurityRule.IS_ANONYMOUS) //TODO
@Controller("/oauth")
public class CustomOAuthController {
    @Get("login")
    HttpResponse<String> login(HttpRequest req) throws URISyntaxException {
        URI uri = UriBuilder.of("https://login.microsoftonline.com/common/oauth2/v2.0/authorize")
                .queryParam("scope", "User.Read")
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", "http://localhost:8080/oauth/callback/microsoft")
                .queryParam("client_id", "28b292b8-b5fd-41be-8b1b-dda96485fb78")
                .build();
        return HttpResponse.redirect(uri);
    }

    @Get("callback/microsoft")
    void obtainAccessToken(@QueryValue String code) {
        System.out.println(code);

    }

}
