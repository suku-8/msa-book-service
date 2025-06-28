package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverCreated extends AbstractEvent {

    private Long bookId;
    private String userId;
    private Date updatedAt;
    private String title;
    private String imageUrl;
    private String generatedBy;
    private Date createdAt;

    public CoverCreated(CoverDesign aggregate) {
        super(aggregate);
    }

    public CoverCreated() {
        super();
    }
}
//>>> DDD / Domain Event
