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
    LibraryRepository libraryRepository;

    @Autowired
    MyLibraryRepository myLibraryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AiSummarized'"
    )
    public void wheneverAiSummarized_PublicationSyncPolicy(
        @Payload AiSummarized aiSummarized
    ) {
        AiSummarized event = aiSummarized;
        System.out.println(
            "\n\n##### listener PublicationSyncPolicy : " +
            aiSummarized +
            "\n\n"
        );

        // Sample Logic //
        Library.publicationSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CoverCreated'"
    )
    public void wheneverCoverCreated_PublicationSyncPolicy(
        @Payload CoverCreated coverCreated
    ) {
        CoverCreated event = coverCreated;
        System.out.println(
            "\n\n##### listener PublicationSyncPolicy : " +
            coverCreated +
            "\n\n"
        );

        // Sample Logic //
        Library.publicationSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookServiceSubscribed'"
    )
    public void wheneverBookServiceSubscribed_SubscriptionSyncPolicy(
        @Payload BookServiceSubscribed bookServiceSubscribed
    ) {
        BookServiceSubscribed event = bookServiceSubscribed;
        System.out.println(
            "\n\n##### listener SubscriptionSyncPolicy : " +
            bookServiceSubscribed +
            "\n\n"
        );

        // Sample Logic //
        MyLibrary.subscriptionSyncPolicy(event);
    }

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
        MyLibrary.pointSyncPolicy(event);
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
        MyLibrary.pointSyncPolicy(event);
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
        MyLibrary.pointSyncPolicy(event);
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
        MyLibrary.pointSyncPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookReadBySubscriber'"
    )
    public void wheneverBookReadBySubscriber_ReadingInfoPolicy(
        @Payload BookReadBySubscriber bookReadBySubscriber
    ) {
        BookReadBySubscriber event = bookReadBySubscriber;
        System.out.println(
            "\n\n##### listener ReadingInfoPolicy : " +
            bookReadBySubscriber +
            "\n\n"
        );

        // Sample Logic //
        Library.readingInfoPolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentedBookRead'"
    )
    public void wheneverRentedBookRead_ReadingInfoPolicy(
        @Payload RentedBookRead rentedBookRead
    ) {
        RentedBookRead event = rentedBookRead;
        System.out.println(
            "\n\n##### listener ReadingInfoPolicy : " + rentedBookRead + "\n\n"
        );

        // Sample Logic //
        Library.readingInfoPolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
