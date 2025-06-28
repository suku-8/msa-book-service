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
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UserRegistered'"
    )
    public void wheneverUserRegistered_InitialPointPolicy(
        @Payload UserRegistered userRegistered
    ) {
        UserRegistered event = userRegistered;
        System.out.println(
            "\n\n##### listener InitialPointPolicy : " + userRegistered + "\n\n"
        );

        // Sample Logic //
        Point.initialPointPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookServiceSubscribed'"
    )
    public void wheneverBookServiceSubscribed_PointDecreasePolicy(
        @Payload BookServiceSubscribed bookServiceSubscribed
    ) {
        BookServiceSubscribed event = bookServiceSubscribed;
        System.out.println(
            "\n\n##### listener PointDecreasePolicy : " +
            bookServiceSubscribed +
            "\n\n"
        );

        // Sample Logic //
        Point.pointDecreasePolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookRented'"
    )
    public void wheneverBookRented_PointDecreasePolicy(
        @Payload BookRented bookRented
    ) {
        BookRented event = bookRented;
        System.out.println(
            "\n\n##### listener PointDecreasePolicy : " + bookRented + "\n\n"
        );

        // Sample Logic //
        Point.pointDecreasePolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
