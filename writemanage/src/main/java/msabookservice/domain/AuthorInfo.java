package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.WritemanageApplication;

@Entity
@Table(name = "AuthorInfo_table")
@Data
//<<< DDD / Aggregate Root
public class AuthorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String authorStatus;

    private String name;

    public static AuthorInfoRepository repository() {
        AuthorInfoRepository authorInfoRepository = WritemanageApplication.applicationContext.getBean(
            AuthorInfoRepository.class
        );
        return authorInfoRepository;
    }

    //<<< Clean Arch / Port Method
    public static void authorInfoPolicy(AuthorApproved authorApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        AuthorInfo authorInfo = new AuthorInfo();
        repository().save(authorInfo);

        */

        /** Example 2:  finding and process
        

        repository().findById(authorApproved.get???()).ifPresent(authorInfo->{
            
            authorInfo // do something
            repository().save(authorInfo);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
