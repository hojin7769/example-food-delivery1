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
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancled'"
    )
    public void wheneverOrderCancled_CancelPayment(
        @Payload OrderCancled orderCancled
    ) {
        OrderCancled event = orderCancled;
        System.out.println(
            "\n\n##### listener CancelPayment : " + orderCancled + "\n\n"
        );

        // Sample Logic //
        Payment.cancelPayment(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReject'"
    )
    public void wheneverOrderReject_CancelPayment(
        @Payload OrderReject orderReject
    ) {
        OrderReject event = orderReject;
        System.out.println(
            "\n\n##### listener CancelPayment : " + orderReject + "\n\n"
        );

        // Sample Logic //
        Payment.cancelPayment(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReject'"
    )
    public void wheneverOrderReject_Cancel(@Payload OrderReject orderReject) {
        OrderReject event = orderReject;
        System.out.println(
            "\n\n##### listener Cancel : " + orderReject + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReject'"
    )
    public void wheneverOrderReject_UpdateStatus(
        @Payload OrderReject orderReject
    ) {
        OrderReject event = orderReject;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + orderReject + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
