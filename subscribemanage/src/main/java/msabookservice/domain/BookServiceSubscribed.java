package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookServiceSubscribed extends AbstractEvent {

    private Long userId;
    private String isSubscribe;

    public BookServiceSubscribed(Subscriber aggregate) {
        super(aggregate);
    }

    public BookServiceSubscribed() {
        super();
    }
}
//>>> DDD / Domain Event
