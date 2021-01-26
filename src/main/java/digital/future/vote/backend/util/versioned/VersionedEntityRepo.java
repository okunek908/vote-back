package digital.future.vote.backend.util.versioned;

import digital.future.vote.backend.domain.Participant;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

import java.time.Instant;

//@JdbcRepository
public interface VersionedEntityRepo<E extends VersionedEntity<ID>, ID> extends CrudRepository<E, ID> {
    @Query("SELECT * FROM entity AS e " +
            "WHERE e.VALID_SINCE <= :time AND (e.VALID_TILL IS NULL OR e.VALID_TILL > :time)")
    Iterable<Participant> findAll(Instant time);

}
