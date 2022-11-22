package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccept extends AbstractEvent {

    private Long id;
    private String orderId;
    private String foodId;
    private String storeAdress;
    private String status;
}
