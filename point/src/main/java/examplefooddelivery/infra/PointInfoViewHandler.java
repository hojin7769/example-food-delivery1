package examplefooddelivery.infra;

import examplefooddelivery.config.kafka.KafkaProcessor;
import examplefooddelivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PointInfoViewHandler {

    @Autowired
    private PointInfoRepository pointInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_CREATE_1(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;

            // view 객체 생성
            PointInfo pointInfo = new PointInfo();
            // view 객체에 이벤트의 Value 를 set 함
            pointInfo.setId(Long.valueOf(delivered.getOrderId()));
            pointInfo.setPoint(0L);
            // view 레파지 토리에 save
            pointInfoRepository.save(pointInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpPointed_then_UPDATE_1(@Payload UpPointed upPointed) {
        try {
            if (!upPointed.validate()) return;
            // view 객체 조회
            Optional<PointInfo> pointInfoOptional = pointInfoRepository.findById(
                Long.valueOf(upPointed.getOrderId())
            );

            if (pointInfoOptional.isPresent()) {
                PointInfo pointInfo = pointInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                pointInfo.setPoint(pointInfo.getPoint() + upPointed.getPoint());
                // view 레파지 토리에 save
                pointInfoRepository.save(pointInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
