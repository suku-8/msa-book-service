package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookRegisted extends AbstractEvent {

    private Long bookId;
    private String userId;
    private String title;
    private String content;

    public BookRegisted(Book aggregate) {
        super(aggregate);
    }

    public BookRegisted() {
        super();
    }
}
//>>> DDD / Domain Event
