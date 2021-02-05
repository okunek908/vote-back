package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.StatusActions;
import digital.future.vote.backend.domain.StatusActionsRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import javax.inject.Inject;
import java.util.List;

@Controller("actions")
public class ActionsController {

    @Inject
    StatusActionsRepo statusActionsRepo;

    @Get
    public List<StatusActions.Action> getActions(@QueryValue String status) {
        return statusActionsRepo.getActionsByStatus(status);
    }
}
