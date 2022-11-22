package examplefooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Point {

    private Long id;
    private Long point;
    private String customerId;
    private String orderId;
}


