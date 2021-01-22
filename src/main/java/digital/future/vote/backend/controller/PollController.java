package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.repo.PollRepo;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.NonNull;
import javax.inject.Inject;

//@Slf4j
@Controller("poll")
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

    @Delete(value = "/id/{id}", consumes = MediaType.ALL)
    public void deletePoll(@NonNull Long id) {
        pollRepository.deleteById(id);
    }
}