package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BestsellerSelected extends AbstractEvent {

    private Long id;

    public BestsellerSelected(Library aggregate) {
        super(aggregate);
    }

    public BestsellerSelected() {
        super();
    }
}
//>>> DDD / Domain Event
