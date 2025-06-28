package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TextUpdated extends AbstractEvent {

    private Long id;

    public TextUpdated(Write aggregate) {
        super(aggregate);
    }

    public TextUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
