package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookServiceSubscribeCanceled extends AbstractEvent {

    private Long id;

    public BookServiceSubscribeCanceled(Subscriber aggregate) {
        super(aggregate);
    }

    public BookServiceSubscribeCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
