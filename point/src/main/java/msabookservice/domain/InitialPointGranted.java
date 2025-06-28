package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InitialPointGranted extends AbstractEvent {

    private Long userId;
    private Integer point;

    public InitialPointGranted(Point aggregate) {
        super(aggregate);
    }

    public InitialPointGranted() {
        super();
    }
}
//>>> DDD / Domain Event
