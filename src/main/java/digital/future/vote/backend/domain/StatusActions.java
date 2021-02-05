package digital.future.vote.backend.domain;

import lombok.Data;

import java.util.Set;

@Data
public class StatusActions {

    private Poll.Status status;

    private Set<Action> actions;

    public StatusActions(Poll.Status status, Set<Action> actions) {
        this.status = status;
        this.actions = actions;
    }

    public enum Action {
        EDIT, DELETE, VIEW
    }
}
