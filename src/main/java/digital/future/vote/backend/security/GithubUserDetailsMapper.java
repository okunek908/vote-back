package digital.future.vote.backend.security;

import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collections;

@Named("github") // name of security configuration in application.yml
@Singleton
public class GithubUserDetailsMapper implements OauthUserDetailsMapper {

    public static final String TOKEN_PREFIX = "token ";
    public static final String ROLE_GITHUB = "ROLE_GITHUB";
    private final GithubApiClient apiClient;

    public GithubUserDetailsMapper(GithubApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Publisher<UserDetails> createUserDetails(TokenResponse tokenResponse) {
        Flowable<User> userx = null;
        try {
            userx = apiClient.getUser(TOKEN_PREFIX + tokenResponse.getAccessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Publisher<UserDetails> result = Flowable.just(new UserDetails(userx.blockingFirst().getLogin(),
                Collections.singletonList(ROLE_GITHUB),
                Collections.singletonMap(OauthUserDetailsMapper.ACCESS_TOKEN_KEY, tokenResponse.getAccessToken())));
//        userx.map(user -> new UserDetails(user.getLogin(),
//                Collections.singletonList(ROLE_GITHUB),
//                Collections.singletonMap(OauthUserDetailsMapper.ACCESS_TOKEN_KEY, tokenResponse.getAccessToken())));
        return result;
    }
}
