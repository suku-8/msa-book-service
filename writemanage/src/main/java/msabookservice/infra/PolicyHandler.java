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
    WriteRepository writeRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorInfoRepository authorInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorApproved'"
    )
    public void wheneverAuthorApproved_AuthorInfoPolicy(
        @Payload AuthorApproved authorApproved
    ) {
        AuthorApproved event = authorApproved;
        System.out.println(
            "\n\n##### listener AuthorInfoPolicy : " + authorApproved + "\n\n"
        );

        // Sample Logic //
        AuthorInfo.authorInfoPolicy(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
