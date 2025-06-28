package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserUpdated extends AbstractEvent {

    public UserUpdated(User aggregate) {
        super(aggregate);
    }

    public UserUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
