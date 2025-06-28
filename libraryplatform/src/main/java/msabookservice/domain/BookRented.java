package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookRented extends AbstractEvent {

    private Long id;

    public BookRented(MyLibrary aggregate) {
        super(aggregate);
    }

    public BookRented() {
        super();
    }
}
//>>> DDD / Domain Event
