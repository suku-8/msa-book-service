package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AiSummarized extends AbstractEvent {

    private Long bookId;
    private String userId;
    private String content;
    private String language;
    private Integer maxLength;
    private String classificationType;
    private String requestedBy;

    public AiSummarized(ContentAnalyzer aggregate) {
        super(aggregate);
    }

    public AiSummarized() {
        super();
    }
}
//>>> DDD / Domain Event
