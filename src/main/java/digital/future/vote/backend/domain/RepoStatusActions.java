package digital.future.vote.backend.domain;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RepoStatusActions {

    private Set<StatusActions> statusActionsSet;

    {
        statusActionsSet = new HashSet<>();
        statusActionsSet.add(new StatusActions(Poll.Status.DRAFT, Sets.newHashSet(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.PUBLISHED, Sets.newHashSet(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.ACTIVE, Sets.newHashSet(StatusActions.Action.VIEW)));
        statusActionsSet.add(new StatusActions(Poll.Status.ENDED, Sets.newHashSet(StatusActions.Action.VIEW)));
    }

    public Set<StatusActions.Action> getActionsByStatus(Poll.Status status) {
        return statusActionsSet.stream().findFirst()
                .filter(statusActions -> status.name().equals(statusActions.getStatus().name())).get().getActions();
    }
}
