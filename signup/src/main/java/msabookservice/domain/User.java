package msabookservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import msabookservice.SignupApplication;
import msabookservice.domain.UserDeleted;
import msabookservice.domain.UserRegistered;
import msabookservice.domain.UserUpdated;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String loginId;

    private String loginPassword;

    @PostPersist
    public void onPostPersist() {
        UserRegistered userRegistered = new UserRegistered(this);
        userRegistered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        UserUpdated userUpdated = new UserUpdated(this);
        userUpdated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        UserDeleted userDeleted = new UserDeleted(this);
        userDeleted.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = SignupApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
//>>> DDD / Aggregate Root
