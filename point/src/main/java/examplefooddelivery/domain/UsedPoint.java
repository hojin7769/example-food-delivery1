package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UsedPoint extends AbstractEvent {

    private Long id;
    private Long point;
    private String customerId;
    private String orderId;

    public UsedPoint(Point aggregate){
        super(aggregate);
    }
    public UsedPoint(){
        super();
    }
}
