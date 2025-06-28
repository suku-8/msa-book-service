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
    CoverDesignRepository coverDesignRepository;

    @Autowired
    ContentAnalyzerRepository contentAnalyzerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookRegisted'"
    )
    public void wheneverBookRegisted_AutoCoverGeneratePolicy(
        @Payload BookRegisted bookRegisted
    ) {
        BookRegisted event = bookRegisted;
        System.out.println(
            "\n\n##### listener AutoCoverGeneratePolicy : " +
            bookRegisted +
            "\n\n"
        );

        // Sample Logic //
        CoverDesign.autoCoverGeneratePolicy(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookRegisted'"
    )
    public void wheneverBookRegisted_AiSummarizePolicy(
        @Payload BookRegisted bookRegisted
    ) {
        BookRegisted event = bookRegisted;
        System.out.println(
            "\n\n##### listener AiSummarizePolicy : " + bookRegisted + "\n\n"
        );

        // Sample Logic //
        ContentAnalyzer.aiSummarizePolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
