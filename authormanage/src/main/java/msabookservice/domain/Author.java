package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.AuthormanageApplication;
import msabookservice.domain.AuthorApproved;
import msabookservice.domain.AuthorRejected;
import msabookservice.domain.AuthorshipApplied;

@Entity
@Table(name = "Author_table")
@Data
//<<< DDD / Aggregate Root
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String authorStatus;

    private String name;

    private String portfolioUrl;

    @PostUpdate
    public void onPostUpdate() {
        AuthorshipApplied authorshipApplied = new AuthorshipApplied(this);
        authorshipApplied.publishAfterCommit();

        AuthorApproved authorApproved = new AuthorApproved(this);
        authorApproved.publishAfterCommit();

        AuthorRejected authorRejected = new AuthorRejected(this);
        authorRejected.publishAfterCommit();
    }

    public static AuthorRepository repository() {
        AuthorRepository authorRepository = AuthormanageApplication.applicationContext.getBean(
            AuthorRepository.class
        );
        return authorRepository;
    }

    //<<< Clean Arch / Port Method
    public static void userInfoSyncPolicy(UserRegistered userRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Author author = new Author();
        repository().save(author);

        */

        /** Example 2:  finding and process
        

        repository().findById(userRegistered.get???()).ifPresent(author->{
            
            author // do something
            repository().save(author);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
