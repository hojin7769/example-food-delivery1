package examplefooddelivery.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private String customerId;
    private String foodId;
    private Object adress;
    private Object options;
    private String status;
    private Long price;
}
