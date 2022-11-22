package examplefooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String customerId;
    private String foodId;
    private String adress;
    private String status;
    private String price;
}


