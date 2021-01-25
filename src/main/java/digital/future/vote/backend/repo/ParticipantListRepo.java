package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Participant;
import digital.future.vote.backend.domain.ParticipantList;
import digital.future.vote.backend.domain.ParticipantListVersion;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;

import javax.transaction.Transactional;
import java.time.Instant;



@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class ParticipantListRepo implements GenericRepository<ParticipantList, String> {
    private final JdbcOperations jdbcOperations;

    public ParticipantListRepo(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Query("SELECT DISTINCT * FROM participant_list AS pl")
    public abstract Iterable<ParticipantList> findAll();

    @Query("SELECT * FROM participant_list_version AS plv WHERE plv.list_id = :listId")
    public abstract Iterable<ParticipantListVersion> findAllVersions(Long listId);

    @Query("SELECT * FROM particpant AS p JOIN participant_list AS pl ON p.LIST_ID = pl.ID " +
            "WHERE pl.TITLE = :listName AND p.VALID_FROM <= :time AND (p.VALID_TILL IS NULL OR p.VALID_TILL > :time)")
    public abstract Iterable<Participant> listParticipants(String listName, Instant time);

    @Query("SELECT * FROM participant AS p JOIN participant_list_version AS plv ON p.LIST_ID = plv.LIST_ID AND plv.version = :version")
    public abstract Iterable<Participant> listParticipants(Long listId, int version);

    @Transactional
    public void addList(String string) {
        //todo : add list, add version
    }

    @Transactional
    public void removeList(String string) {
        //todo : find list and versions, remove versions, remove list
    }

    @Transactional
    public void addParticipant(String listName, String participantId) {
        //todo: find list, create and add participant, update version of list
    }

    @Transactional
    public void removeParticipant(String listName, String participantId) {
        //todo: find participant, set valid_till to now, find list, create version, update list with last version
    }
}
