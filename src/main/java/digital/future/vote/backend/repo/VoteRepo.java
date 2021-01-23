package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Vote;
import digital.future.vote.backend.util.UID;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface VoteRepo extends CrudRepository<Vote, UID> {

}
