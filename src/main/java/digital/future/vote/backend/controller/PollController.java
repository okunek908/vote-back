package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.repo.PollRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import lombok.NonNull;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDateTime;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import static java.util.Collections.emptyList;

@Controller("poll")
public class PollController {
    @Inject
    PollRepository pollRepository;

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
    public Poll getPoll(@NotNull Long id) {
        return pollRepository.findById(id).orElseThrow();
    }

    @Delete("/id/{id}")
    public void deletePoll(Long id) {
        pollRepository.deleteById(id);
    }
}