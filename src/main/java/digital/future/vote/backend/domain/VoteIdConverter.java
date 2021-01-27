package digital.future.vote.backend.domain;

import digital.future.vote.backend.util.UID;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.convert.TypeConverter;

import javax.inject.Singleton;
import java.util.Optional;

// Converter that is invoked when loading from / saving to the database.
@Factory
public class VoteIdConverter {
    @Singleton
    TypeConverter<VoteId, String> uid2string() {
        return (object, targetType, context) -> Optional.of(object.toString());
    }

    @Singleton
    TypeConverter<String, VoteId> string2uid() {
        return (object, targetType, context) -> Optional.of(new VoteId(object));
    }
}
