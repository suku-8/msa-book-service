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
    SubscriberRepository subscriberRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InitialPointGranted'"
    )
    public void wheneverInitialPointGranted_PointSyncPolicy(
        @Payload InitialPointGranted initialPointGranted
    ) {
        InitialPointGranted event = initialPointGranted;
        System.out.println(
            "\n\n##### listener PointSyncPolicy : " +
            initialPointGranted +
            "\n\n"
        );

        // Sample Logic //
        Subscriber.pointSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointGrantedForKtAuth'"
    )
    public void wheneverPointGrantedForKtAuth_PointSyncPolicy(
        @Payload PointGrantedForKtAuth pointGrantedForKtAuth
    ) {
        PointGrantedForKtAuth event = pointGrantedForKtAuth;
        System.out.println(
            "\n\n##### listener PointSyncPolicy : " +
            pointGrantedForKtAuth +
            "\n\n"
        );

        // Sample Logic //
        Subscriber.pointSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointAdded'"
    )
    public void wheneverPointAdded_PointSyncPolicy(
        @Payload PointAdded pointAdded
    ) {
        PointAdded event = pointAdded;
        System.out.println(
            "\n\n##### listener PointSyncPolicy : " + pointAdded + "\n\n"
        );

        // Sample Logic //
        Subscriber.pointSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointDecreased'"
    )
    public void wheneverPointDecreased_PointSyncPolicy(
        @Payload PointDecreased pointDecreased
    ) {
        PointDecreased event = pointDecreased;
        System.out.println(
            "\n\n##### listener PointSyncPolicy : " + pointDecreased + "\n\n"
        );

        // Sample Logic //
        Subscriber.pointSyncPolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
