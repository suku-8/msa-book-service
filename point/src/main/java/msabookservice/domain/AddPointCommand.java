// AddPointCommand.java
package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AddPointCommand {

    // --- 기능 추가 ---
    // 프론트엔드에서 충전할 포인트 금액을 받아올 필드
    private Integer amount;
}