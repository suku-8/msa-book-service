package msabookservice.domain;

import java.util.*;
import lombok.*;
import msabookservice.domain.*;
import msabookservice.infra.AbstractEvent;

@Data
@ToString
public class InitialPointGranted extends AbstractEvent {

    private Long userId;
    private Integer point;
}
