package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RentedBookRead extends AbstractEvent {

    private Long id;

    public RentedBookRead(MyLibrary aggregate) {
        super(aggregate);
    }

    public RentedBookRead() {
        super();
    }
}
//>>> DDD / Domain Event
