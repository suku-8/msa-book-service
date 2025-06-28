package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.PointApplication;
import msabookservice.domain.InitialPointGranted;
import msabookservice.domain.PointAdded;
import msabookservice.domain.PointDecreased;
import msabookservice.domain.PointGrantedForKtAuth;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private Integer point;

    private String isKt;

    // @PostUpdate
    // public void onPostUpdate() {
    //     PointAdded pointAdded = new PointAdded(this);
    //     pointAdded.publishAfterCommit();

    //     PointGrantedForKtAuth pointGrantedForKtAuth = new PointGrantedForKtAuth(
    //         this
    //     );
    //     pointGrantedForKtAuth.publishAfterCommit();
    // }


    public void authKtUser(String isKtValue) {
        // --- 기능 추가 ---
        // 파라미터로 받은 isKtValue가 "Y"이면,
        if ("Y".equals(isKtValue)) {
            // 기존 포인트에 5000점을 더합니다.
            this.setPoint(this.getPoint() + 5000);
            this.setIsKt("Y");
        }

        // KT 인증 포인트가 지급되었다는 이벤트를 발행합니다.
        PointGrantedForKtAuth pointGrantedForKtAuth = new PointGrantedForKtAuth(this);
        pointGrantedForKtAuth.publishAfterCommit();
    }
    public void addPoint(Integer amountToAdd) {
        // --- 기능 추가 ---
        // 기존 포인트에 파라미터로 받은 충전할 금액을 더합니다.
        if (amountToAdd != null && amountToAdd > 0) {
            this.setPoint(this.getPoint() + amountToAdd);
        }

        // 포인트가 충전되었다는 이벤트를 발행합니다.
        PointAdded pointAdded = new PointAdded(this);
        pointAdded.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public static void initialPointPolicy(UserRegistered userRegistered) {
        System.out.println("신규 가입자 이벤트 수신: " + userRegistered.toJson());

        // 1. 새로운 Point 객체를 생성합니다.
        Point point = new Point();

        // 2. UserRegistered 이벤트에서 받은 userId를 설정합니다.
        point.setUserId(userRegistered.getUserId());

        // 3. (비즈니스 로직) 초기 포인트를 1000점으로 설정합니다.
        point.setPoint(1000); 

        // 4. DB에 새로운 Point 데이터를 저장합니다.
        repository().save(point);

        // 5. 포인트가 지급되었다는 새로운 이벤트를 발행합니다.
        // 이벤트 이름은 InitialPointGranted 보다는 PointGrantedForNewUser 등이 더 명확할 수 있습니다.
        InitialPointGranted initialPointGranted = new InitialPointGranted(point);
        initialPointGranted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointDecreasePolicy(
        BookServiceSubscribed bookServiceSubscribed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointDecreased pointDecreased = new PointDecreased(point);
        pointDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookServiceSubscribed.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointDecreased pointDecreased = new PointDecreased(point);
            pointDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointDecreasePolicy(BookRented bookRented) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointDecreased pointDecreased = new PointDecreased(point);
        pointDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookRented.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointDecreased pointDecreased = new PointDecreased(point);
            pointDecreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
