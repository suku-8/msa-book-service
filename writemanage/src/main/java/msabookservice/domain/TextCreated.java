package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TextCreated extends AbstractEvent {

    private Long id;

    public TextCreated(Write aggregate) {
        super(aggregate);
    }

    public TextCreated() {
        super();
    }
}
//>>> DDD / Domain Event
