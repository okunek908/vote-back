package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import io.micronaut.http.annotation.*;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

import static java.util.Collections.emptyList;

@Controller("poll")
public class PollController {
    @Get
    public List<Poll> getAllPolls() {
        return emptyList();
//        return List.of(
//            new Poll("Poll1", LocalDateTime.now(), LocalDateTime.now(), emptyList()),
//            new Poll("Poll2", LocalDateTime.now(), LocalDateTime.now(), emptyList())
//        );
    }

    @Post
    public Poll createPoll(@Body Poll poll)  {
        throw new NotImplementedException("");
    }

    @Get("/id/{id}")
    public Poll getPoll(@NotNull Long id) {
        return new Poll("Poll1", LocalDateTime.now(), LocalDateTime.now(), emptyList());
    }

    @Delete("/id/{id}")
    public Long deletePoll(Long id) {
        throw new NotImplementedException("");
    }
}