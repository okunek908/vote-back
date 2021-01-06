package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.repo.PollRepository;
import io.micronaut.http.annotation.*;
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

    @Post
    public Poll createPoll(@Body Poll poll)  {
        throw new NotImplementedException("");
    }

    @Get("/id/{id}")
    public Poll getPoll(@NotNull Long id) {
        return new Poll("Title", LocalDateTime.now(), LocalDateTime.now());
    }

    @Delete("/id/{id}")
    public Long deletePoll(Long id) {
        throw new NotImplementedException("");
    }
}