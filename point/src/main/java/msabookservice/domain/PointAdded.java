package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointAdded extends AbstractEvent {

    private Long userId;
    private Integer point;

    public PointAdded(Point aggregate) {
        super(aggregate);
    }

    public PointAdded() {
        super();
    }
}
//>>> DDD / Domain Event
