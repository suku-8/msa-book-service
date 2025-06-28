package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private Long userId;

    public UserRegistered(User aggregate) {
        super(aggregate);
    }

    public UserRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
