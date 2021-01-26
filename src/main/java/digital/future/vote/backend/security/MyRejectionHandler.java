package digital.future.vote.backend.security;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.AuthorizationException;
import io.micronaut.security.authentication.DefaultAuthorizationExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
@Replaces(DefaultAuthorizationExceptionHandler.class)
public class MyRejectionHandler extends DefaultAuthorizationExceptionHandler {
    Logger LOG = LoggerFactory.getLogger(MyRejectionHandler.class);

    @Override
    public MutableHttpResponse<?> handle(HttpRequest request, AuthorizationException exception) {
        //Let the DefaultAuthorizationExceptionHandler create the initial response
        //then add a header
        LOG.error("E", exception);
        return super.handle(request, exception).header("X-Reason", "Example Header");
    }
}
