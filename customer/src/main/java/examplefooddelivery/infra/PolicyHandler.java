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
    NotifyLogRepository notifyLogRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @Autowired
    examplefooddelivery.external.OrderService orderService;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_AppNotify(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener AppNotify : " + orderPlaced + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccept'"
    )
    public void wheneverOrderAccept_AppNotify(
        @Payload OrderAccept orderAccept
    ) {
        OrderAccept event = orderAccept;
        System.out.println(
            "\n\n##### listener AppNotify : " + orderAccept + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReject'"
    )
    public void wheneverOrderReject_AppNotify(
        @Payload OrderReject orderReject
    ) {
        OrderReject event = orderReject;
        System.out.println(
            "\n\n##### listener AppNotify : " + orderReject + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_AppNotify(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener AppNotify : " + cookStarted + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_AppNotify(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener AppNotify : " + cookFinished + "\n\n"
        );

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Picked'"
    )
    public void wheneverPicked_AppNotify(@Payload Picked picked) {
        Picked event = picked;
        System.out.println("\n\n##### listener AppNotify : " + picked + "\n\n");

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_AppNotify(@Payload Paid paid) {
        Paid event = paid;
        System.out.println("\n\n##### listener AppNotify : " + paid + "\n\n");

        // REST Request Sample

        // orderService.getOrder(/** mapping value needed */);

        // Sample Logic //
        NotifyLog.appNotify(event);
    }
}
