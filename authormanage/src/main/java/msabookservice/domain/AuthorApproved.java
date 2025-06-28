package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorApproved extends AbstractEvent {

    private Long userId;
    private String authorStatus;
    private String name;

    public AuthorApproved(Author aggregate) {
        super(aggregate);
    }

    public AuthorApproved() {
        super();
    }
}
//>>> DDD / Domain Event
