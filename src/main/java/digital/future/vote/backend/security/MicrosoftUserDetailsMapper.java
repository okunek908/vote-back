package digital.future.vote.backend.security;


import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.authorization.state.State;
import io.micronaut.security.oauth2.endpoint.token.response.OauthUserDetailsMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;

import io.reactivex.Single;
import org.reactivestreams.Publisher;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Map;

@Named("microsoft") // name of security configuration in application.yml AND the path element in urls:
// '/oauth/login/microsoft' and '/oath/callback/microsoft'
@Singleton
public class MicrosoftUserDetailsMapper implements OauthUserDetailsMapper {
    private final MicrosoftApiClient2 apiClient;

    public MicrosoftUserDetailsMapper(MicrosoftApiClient2 apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Publisher<AuthenticationResponse> createAuthenticationResponse(TokenResponse tokenResponse,
                                                                          @Nullable State state) {
        Single<User> microsoftUserSingle = apiClient.getUser(tokenResponse.getAccessToken());
        User user = microsoftUserSingle.blockingGet();
        return Publishers.just(
                new UserDetails(
                        user.getUserPrincipalName(),
                        Collections.singletonList("user"),
                        Map.of(
                                OauthUserDetailsMapper.ACCESS_TOKEN_KEY, tokenResponse.getAccessToken(),
                                "user", user
                        )
                )
        );
    }

    @Override
    public Publisher<UserDetails> createUserDetails(TokenResponse tokenResponse) {
        return null;
    }
}
