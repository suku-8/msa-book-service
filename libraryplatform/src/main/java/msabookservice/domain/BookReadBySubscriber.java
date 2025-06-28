package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookReadBySubscriber extends AbstractEvent {

    private Long id;

    public BookReadBySubscriber(MyLibrary aggregate) {
        super(aggregate);
    }

    public BookReadBySubscriber() {
        super();
    }
}
//>>> DDD / Domain Event
