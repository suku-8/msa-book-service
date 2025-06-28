package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorshipApplied extends AbstractEvent {

    public AuthorshipApplied(Author aggregate) {
        super(aggregate);
    }

    public AuthorshipApplied() {
        super();
    }
}
//>>> DDD / Domain Event
