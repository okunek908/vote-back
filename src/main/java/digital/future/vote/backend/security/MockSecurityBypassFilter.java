package digital.future.vote.backend.security;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@Filter("/**")
@Requires(env = Environment.TEST) // not used now, but maybe will do for tests
@Requires(property = "spec.name", notEquals = "SecuritySpec")
public class MockSecurityBypassFilter implements HttpClientFilter
{
    private final static Logger LOG = LoggerFactory.getLogger(MockSecurityBypassFilter.class);

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain)
    {
        LOG.info(">>> Mock Security Filter automatic sign in");
        // token expire at -> Saturday, April 20, 2030 9:39:44 PM GMT-03:00
        final String JWT_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluQG5vaG9tZS5jb20iLCJyb2xlcyI6WyJST09UIiwiU1VQRVJfQURNSU4iLCJVU0VSU19BRE1JTiIsIlVTRVJTX1JFQUQiLCJVU0VSU19XUklURSIsIkFDQ1RTX0FETUlOIiwiQUNDVFNfUkVBRCIsIkFDQ1RTX1dSSVRFIiwiQ1VTVFNfQURNSU4iLCJDVVNUU19SRUFEIiwiQ1VTVFNfV1JJVEUiLCJMQUJPUl9BRE1JTiIsIkxBQk9SX1JFQUQiLCJMQUJPUl9XUklURSIsIlNBTEVTUkVQIl0sImlzcyI6InVzZXJzIiwiYWNjdElkIjoiQWNjdFZwVWdxSzBOIiwib3duZXJJZCI6Ik93bmN5YWZ0Q2giLCJsb2NhbGUiOiJwdCIsIm1vZHVsZXMiOlsiU0FMRVNfUkVQIl0sInNpZCI6ImplczV3U2doemNodiIsIm5iZiI6MTU5NDI3MTEzOCwic2VyaWFsIjoiNTY3ODkiLCJhY2Nlc3NDb2RlIjoiUjEwMCIsIm5hbWUiOiJMdWtlIFNreXdhbGtlciIsInpvbmVJZCI6IlVUQy0zIiwiZXhwIjoxOTA5NjMxMTM4LCJpYXQiOjE1OTQyNzExMzh9.-MXKLJe7iqpAcdViFtcHFg2Yvcypf9E3KVLyxc";
        request.bearerAuth(JWT_TOKEN);
        return chain.proceed(request);
    }
}
