package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import examplefooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyDeliveryInfoViewHandler {


    @Autowired
    private MyDeliveryInfoRepository myDeliveryInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyDeliveryInfo myDeliveryInfo = new MyDeliveryInfo();
            // view 객체에 이벤트의 Value 를 set 함
            myDeliveryInfo.setFoodId(orderPlaced.getFoodId());
            myDeliveryInfo.setId(orderPlaced.getId());
            myDeliveryInfo.setStatus("주문됨");
            // view 레파지 토리에 save
            myDeliveryInfoRepository.save(myDeliveryInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(paid.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("결제됨");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccept_then_UPDATE_2(@Payload OrderAccept orderAccept) {
        try {
            if (!orderAccept.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(orderAccept.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("접수됨");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderReject_then_UPDATE_3(@Payload OrderReject orderReject) {
        try {
            if (!orderReject.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(orderReject.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("취소됨");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(cookStarted.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("조리시작");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_5(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(cookFinished.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("조리완료");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_6(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(picked.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("배송시작");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_7(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
            Optional<MyDeliveryInfo> myDeliveryInfoOptional = myDeliveryInfoRepository.findById(Long.valueOf(delivered.getOrderId()));

            if( myDeliveryInfoOptional.isPresent()) {
                 MyDeliveryInfo myDeliveryInfo = myDeliveryInfoOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myDeliveryInfo.setStatus("배송완료");    
                // view 레파지 토리에 save
                 myDeliveryInfoRepository.save(myDeliveryInfo);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

