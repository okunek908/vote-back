package digital.future.vote.backend.repository;

import digital.future.vote.backend.domain.Poll;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}
