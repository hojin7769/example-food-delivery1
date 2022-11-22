package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String foodId;
    private String adress;
    private List<String> options;
    private String status;

    public OrderCancled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancled() {
        super();
    }
}
