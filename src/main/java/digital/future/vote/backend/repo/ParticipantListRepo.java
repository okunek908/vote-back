package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Participant;
import digital.future.vote.backend.domain.ParticipantList;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;



@JdbcRepository(dialect = Dialect.POSTGRES)
interface ParticipantListRepo extends CrudRepository<ParticipantList, Long> {

    @Query("SELECT pl.participants FROM particpant_list AS pl WHERE pl.id = :listId")
    Iterable<Participant> listParticipants(Long listId);

//    //TODO
//    void addParticipantsBulk(Long listId, String... participantIds);
//
//    //TODO
//    void removeParticipant(Long listId, String... participantId);
}
