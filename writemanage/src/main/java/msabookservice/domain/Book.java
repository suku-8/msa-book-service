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
import msabookservice.domain.BookRegisted;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String originWriteId;

    private String userId;

    private String title;

    private String content;

    @PreUpdate
    public void onPreUpdate() {
        BookRegisted bookRegisted = new BookRegisted(this);
        bookRegisted.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = WritemanageApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }
}
//>>> DDD / Aggregate Root
