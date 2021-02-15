package digital.future.vote.backend.security;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import javax.inject.Singleton;
import java.util.ArrayList;

import org.reactivestreams.Publisher;

// For testing purposes. TODO: Remove on prod!
//@Requires(env = Environment.TEST)
@Singleton
public class FakeAuthenticationProvider implements AuthenticationProvider  {
    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            if ( authenticationRequest.getIdentity().equals("Aladdin") &&
                    authenticationRequest.getSecret().equals("open sesame") ) {
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.BUFFER);
    }
}
