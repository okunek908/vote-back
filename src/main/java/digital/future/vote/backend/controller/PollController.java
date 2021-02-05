package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.repo.PollRepo;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.NonNull;
import javax.inject.Inject;

//@Slf4j
@Secured(SecurityRule.IS_ANONYMOUS) //TODO
@Controller("/poll")
public class PollController {
    @Inject
    PollRepo pollRepository;

    @Get
    public Iterable<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public Poll createPoll(@NonNull @Body PollDto dto)  {
        Poll poll = new Poll();
        dto.updateEntity(poll);
        return pollRepository.save(poll);
    }

    @Get("/id/{id}")
    public Poll getPoll(@NonNull Long id) {
        return pollRepository.findById(id).orElseThrow();
    }

    @Put("/id/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Poll updatePoll(@NonNull Long id, @NonNull @Body PollDto dto)  {
        Poll poll = pollRepository.findById(id).orElseThrow();
        dto.updateEntity(poll);
        return pollRepository.update(poll);
    }

    @Delete(value = "/id/{id}", consumes = MediaType.ALL)
    public void deletePoll(@NonNull Long id) {
        pollRepository.deleteById(id);
    }
}