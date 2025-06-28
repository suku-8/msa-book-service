package msabookservice.domain;

import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

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
}
