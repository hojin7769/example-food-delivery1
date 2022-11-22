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
    StoreRepository storeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_주문정보추가(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener 주문정보추가 : " + paid + "\n\n"
        );

        // Sample Logic //
        Store.주문정보추가(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancled'"
    )
    public void wheneverOrderCancled_주문취소알림(
        @Payload OrderCancled orderCancled
    ) {
        OrderCancled event = orderCancled;
        System.out.println(
            "\n\n##### listener 주문취소알림 : " + orderCancled + "\n\n"
        );

        // Sample Logic //
        Store.주문취소알림(event);
    }
}
