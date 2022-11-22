package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import examplefooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private String address;
    private String orderId;
}
