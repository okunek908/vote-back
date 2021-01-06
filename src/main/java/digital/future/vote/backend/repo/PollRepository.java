package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Poll;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

//@Repository
@JdbcRepository(dialect = Dialect.H2)
public interface PollRepository extends CrudRepository<Poll, Long> {
}
