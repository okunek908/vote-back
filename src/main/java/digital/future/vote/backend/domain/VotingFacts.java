package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Additional info about voting action: circumstances and environment details.
 */
@Data
@NoArgsConstructor
public class VotingFacts {
    public enum DeviceType {PHONE, TABLET, PC}
    DeviceType device;
    String os;
    String ip;
    String location;
}
