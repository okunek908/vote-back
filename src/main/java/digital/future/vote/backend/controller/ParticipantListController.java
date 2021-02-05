package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.ParticipantList;
import digital.future.vote.backend.repo.ParticipantListRepo;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.NonNull;

import javax.inject.Inject;

@Controller("/participants")
@Secured(SecurityRule.IS_ANONYMOUS) //TODO
public class ParticipantListController {
    @Inject
    ParticipantListRepo participantListRepo;

    @Get
    public Iterable<ParticipantList> getLists() {
        return participantListRepo.findAll();
    }

    @Get("/id/{id}")
    public ParticipantList getListById(@NonNull Long id) {
        return participantListRepo.findById(id).orElseThrow();
    }

    @Post
    public ParticipantList saveList(ParticipantList list) {
        return participantListRepo.save(list);
    }

    @Put("/id/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ParticipantList updateList(@NonNull Long id, @NonNull @Body ParticipantList in)  {
        ParticipantList stored = participantListRepo.findById(id).orElseThrow();
        // validate?
        return participantListRepo.update(in);
    }

    @Delete(value = "/id/{id}", consumes = MediaType.ALL)
    public void deleteList(@NonNull Long id) {
        participantListRepo.deleteById(id);
    }
}
