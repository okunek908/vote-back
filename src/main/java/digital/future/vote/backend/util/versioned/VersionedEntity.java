package digital.future.vote.backend.util.versioned;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.annotation.Version;
import io.micronaut.data.model.DataType;
import lombok.Data;
import lombok.NonNull;

import java.time.Instant;

/**
 * Versioned Entity functionality:
 *  - possibility to find entities existing on any point in time in the past
 *  - possibility to soft-delete
 *  - possibility to track entity changes
 * @param <ID> Class that designates Primary Key of entity
 */
@Data
public class VersionedEntity<ID> {
    @Id
    ID id;

    @Version
    Integer version;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    @NonNull
    Instant validSince;

    @TypeDef(type = DataType.TIMESTAMP)
    Instant validTill;
}
