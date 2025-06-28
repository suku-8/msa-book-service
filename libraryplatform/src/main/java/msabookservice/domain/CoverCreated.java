package msabookservice.domain;

import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

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
}
