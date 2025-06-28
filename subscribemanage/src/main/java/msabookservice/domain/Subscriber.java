package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.SubscribemanageApplication;
import msabookservice.domain.BookServiceSubscribeCanceled;
import msabookservice.domain.BookServiceSubscribed;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private Integer point;

    private String isSubscribe;

    @PostUpdate
    public void onPostUpdate() {
        BookServiceSubscribed bookServiceSubscribed = new BookServiceSubscribed(
            this
        );
        bookServiceSubscribed.publishAfterCommit();

        BookServiceSubscribeCanceled bookServiceSubscribeCanceled = new BookServiceSubscribeCanceled(
            this
        );
        bookServiceSubscribeCanceled.publishAfterCommit();
    }

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscribemanageApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(
        InitialPointGranted initialPointGranted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        

        repository().findById(initialPointGranted.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(
        PointGrantedForKtAuth pointGrantedForKtAuth
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointGrantedForKtAuth.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(PointAdded pointAdded) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointAdded.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointDecreased.get???()).ifPresent(subscriber->{
            
            subscriber // do something
            repository().save(subscriber);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
