package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.LibraryplatformApplication;
import msabookservice.domain.BookReadBySubscriber;
import msabookservice.domain.BookRented;
import msabookservice.domain.RentedBookRead;

@Entity
@Table(name = "MyLibrary_table")
@Data
//<<< DDD / Aggregate Root
public class MyLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String point;

    private String isSubscribe;

    private String bookId;

    private String isBuy;

    @PostUpdate
    public void onPostUpdate() {
        BookRented bookRented = new BookRented(this);
        bookRented.publishAfterCommit();

        BookReadBySubscriber bookReadBySubscriber = new BookReadBySubscriber(
            this
        );
        bookReadBySubscriber.publishAfterCommit();

        RentedBookRead rentedBookRead = new RentedBookRead(this);
        rentedBookRead.publishAfterCommit();
    }

    public static MyLibraryRepository repository() {
        MyLibraryRepository myLibraryRepository = LibraryplatformApplication.applicationContext.getBean(
            MyLibraryRepository.class
        );
        return myLibraryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void subscriptionSyncPolicy(
        BookServiceSubscribed bookServiceSubscribed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        MyLibrary myLibrary = new MyLibrary();
        repository().save(myLibrary);

        */

        /** Example 2:  finding and process
        

        repository().findById(bookServiceSubscribed.get???()).ifPresent(myLibrary->{
            
            myLibrary // do something
            repository().save(myLibrary);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(
        InitialPointGranted initialPointGranted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        MyLibrary myLibrary = new MyLibrary();
        repository().save(myLibrary);

        */

        /** Example 2:  finding and process
        

        repository().findById(initialPointGranted.get???()).ifPresent(myLibrary->{
            
            myLibrary // do something
            repository().save(myLibrary);


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
        MyLibrary myLibrary = new MyLibrary();
        repository().save(myLibrary);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointGrantedForKtAuth.get???()).ifPresent(myLibrary->{
            
            myLibrary // do something
            repository().save(myLibrary);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(PointAdded pointAdded) {
        //implement business logic here:

        /** Example 1:  new item 
        MyLibrary myLibrary = new MyLibrary();
        repository().save(myLibrary);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointAdded.get???()).ifPresent(myLibrary->{
            
            myLibrary // do something
            repository().save(myLibrary);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void pointSyncPolicy(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        MyLibrary myLibrary = new MyLibrary();
        repository().save(myLibrary);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointDecreased.get???()).ifPresent(myLibrary->{
            
            myLibrary // do something
            repository().save(myLibrary);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
