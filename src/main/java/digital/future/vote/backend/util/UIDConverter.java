package digital.future.vote.backend.util;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.convert.TypeConverter;

import javax.inject.Singleton;
import java.util.Optional;

@Factory
public class UIDConverter {
    @Singleton
    TypeConverter<UID, String> uid2string() {
        return (object, targetType, context) -> Optional.of(object.toString());
    }

    @Singleton
    TypeConverter<String, UID> string2uid() {
        return (object, targetType, context) -> Optional.of(new UID(object));
    }
}
