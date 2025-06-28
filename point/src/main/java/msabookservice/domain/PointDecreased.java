package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private Long userId;
    private Integer point;

    public PointDecreased(Point aggregate) {
        super(aggregate);
    }

    public PointDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
