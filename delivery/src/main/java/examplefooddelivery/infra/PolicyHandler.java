package examplefooddelivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import examplefooddelivery.config.kafka.KafkaProcessor;
import examplefooddelivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeilveryRepository deilveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    examplefooddelivery.external.OrderService orderService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_배달목록추가(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener 배달목록추가 : " + cookFinished + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        Deilvery.배달목록추가(event);
    }
}
