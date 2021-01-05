package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Vote;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.constraints.NotNull;
import java.util.Collections;

@Controller("vote")
public class VoteController {
    @Post
    public Long saveVote(@Body Vote vote) {
        return 17L;//TODO
    }

    @Get("id/{id}")
    public Vote getVote(@NotNull Long id) {
        return new Vote(id, Collections.emptyMap());
    }
}
