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
import msabookservice.domain.BestsellerSelected;

@Entity
@Table(name = "Library_table")
@Data
//<<< DDD / Aggregate Root
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String userId;

    private String bookTitle;

    private String author;

    private String summary;

    private String imageUrl;

    private Date publishDate;

    private Integer viewCount;

    private String rank;

    private Boolean bestseller;

    private String category;

    private String tags;

    @PostPersist
    public void onPostPersist() {
        BestsellerSelected bestsellerSelected = new BestsellerSelected(this);
        bestsellerSelected.publishAfterCommit();
    }

    public static LibraryRepository repository() {
        LibraryRepository libraryRepository = LibraryplatformApplication.applicationContext.getBean(
            LibraryRepository.class
        );
        return libraryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void publicationSyncPolicy(AiSummarized aiSummarized) {
        //implement business logic here:

        /** Example 1:  new item 
        Library library = new Library();
        repository().save(library);

        */

        /** Example 2:  finding and process
        
        // if aiSummarized.aiGpt4_1MiniId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> contentAnalyzerMap = mapper.convertValue(aiSummarized.getAiGpt4_1MiniId(), Map.class);

        repository().findById(aiSummarized.get???()).ifPresent(library->{
            
            library // do something
            repository().save(library);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void publicationSyncPolicy(CoverCreated coverCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Library library = new Library();
        repository().save(library);

        */

        /** Example 2:  finding and process
        
        // if coverCreated.aiDallEId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> coverDesignMap = mapper.convertValue(coverCreated.getAiDallEId(), Map.class);

        repository().findById(coverCreated.get???()).ifPresent(library->{
            
            library // do something
            repository().save(library);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void readingInfoPolicy(
        BookReadBySubscriber bookReadBySubscriber
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Library library = new Library();
        repository().save(library);

        */

        /** Example 2:  finding and process
        

        repository().findById(bookReadBySubscriber.get???()).ifPresent(library->{
            
            library // do something
            repository().save(library);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void readingInfoPolicy(RentedBookRead rentedBookRead) {
        //implement business logic here:

        /** Example 1:  new item 
        Library library = new Library();
        repository().save(library);

        */

        /** Example 2:  finding and process
        

        repository().findById(rentedBookRead.get???()).ifPresent(library->{
            
            library // do something
            repository().save(library);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
