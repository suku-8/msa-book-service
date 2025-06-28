package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointGrantedForKtAuth extends AbstractEvent {

    private Long userId;
    private Integer point;

    public PointGrantedForKtAuth(Point aggregate) {
        super(aggregate);
    }

    public PointGrantedForKtAuth() {
        super();
    }
}
//>>> DDD / Domain Event
