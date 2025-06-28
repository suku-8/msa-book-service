package msabookservice.domain;

import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

@Data
@ToString
public class BookRegisted extends AbstractEvent {

    private Long bookId;
    private String userId;
    private String title;
    private String content;
}
