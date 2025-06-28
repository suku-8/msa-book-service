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

    @PostUpdate
    public void onPostUpdate() {
        PointAdded pointAdded = new PointAdded(this);
        pointAdded.publishAfterCommit();

        PointGrantedForKtAuth pointGrantedForKtAuth = new PointGrantedForKtAuth(
            this
        );
        pointGrantedForKtAuth.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public static void initialPointPolicy(UserRegistered userRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        InitialPointGranted initialPointGranted = new InitialPointGranted(point);
        initialPointGranted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userRegistered.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            InitialPointGranted initialPointGranted = new InitialPointGranted(point);
            initialPointGranted.publishAfterCommit();

         });
        */

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
