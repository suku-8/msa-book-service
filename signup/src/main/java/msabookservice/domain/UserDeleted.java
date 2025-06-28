package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserDeleted extends AbstractEvent {

    public UserDeleted(User aggregate) {
        super(aggregate);
    }

    public UserDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
