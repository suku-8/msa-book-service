package msabookservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import msabookservice.config.kafka.KafkaProcessor;
import msabookservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AuthorRepository authorRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UserRegistered'"
    )
    public void wheneverUserRegistered_UserInfoSyncPolicy(
        @Payload UserRegistered userRegistered
    ) {
        UserRegistered event = userRegistered;
        System.out.println(
            "\n\n##### listener UserInfoSyncPolicy : " + userRegistered + "\n\n"
        );

        // Sample Logic //
        Author.userInfoSyncPolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
