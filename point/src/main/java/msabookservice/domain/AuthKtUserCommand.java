// AuthKtUserCommand.java
package msabookservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AuthKtUserCommand {
    
    // --- 기능 추가 ---
    // 프론트엔드에서 "Y" 같은 KT 인증 값을 받아올 필드
    private String isKt; 
}