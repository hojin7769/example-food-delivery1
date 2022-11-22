package examplefooddelivery.domain;

import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Delivered extends AbstractEvent {

    private Long id;
    private String address;
    private String orderId;
}
