package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UpPointed extends AbstractEvent {

    private Long id;
    private Long point;
    private String customerId;
    private String orderId;

    public UpPointed(Point aggregate) {
        super(aggregate);
    }

    public UpPointed() {
        super();
    }
}
