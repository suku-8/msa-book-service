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
import msabookservice.domain.TextCreated;
import msabookservice.domain.TextUpdated;

@Entity
@Table(name = "Write_table")
@Data
//<<< DDD / Aggregate Root
public class Write {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long writeId;

    private Long userId;

    private String authorStatus;

    private String title;

    private String content;

    @PostUpdate
    public void onPostUpdate() {
        TextCreated textCreated = new TextCreated(this);
        textCreated.publishAfterCommit();

        TextUpdated textUpdated = new TextUpdated(this);
        textUpdated.publishAfterCommit();
    }

    public static WriteRepository repository() {
        WriteRepository writeRepository = WritemanageApplication.applicationContext.getBean(
            WriteRepository.class
        );
        return writeRepository;
    }
}
//>>> DDD / Aggregate Root
