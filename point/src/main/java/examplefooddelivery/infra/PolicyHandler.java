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
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    examplefooddelivery.external.OrderService orderService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Delivered'"
    )
    public void wheneverDelivered_Point(@Payload Delivered delivered) {
        Delivered event = delivered;
        System.out.println("\n\n##### listener Point : " + delivered + "\n\n");

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        Point.point(event);
    }
}
