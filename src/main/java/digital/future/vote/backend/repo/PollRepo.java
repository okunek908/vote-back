package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.util.UID;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PollRepo extends CrudRepository<Poll, Long> {
    @Query("SELECT * FROM poll WHERE publicId=:publicId")
    Poll findByPublicId(UID publicId);
}
