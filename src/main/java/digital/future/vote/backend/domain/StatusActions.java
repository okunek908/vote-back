package digital.future.vote.backend.domain;

import lombok.Data;

import java.util.List;

@Data
public class StatusActions {

    private Poll.Status status;

    private List<Action> actions;

    public StatusActions(Poll.Status status, List<Action> actions) {
        this.status = status;
        this.actions = actions;
    }

    public enum Action {
        EDIT, DELETE, VIEW
    }
}
