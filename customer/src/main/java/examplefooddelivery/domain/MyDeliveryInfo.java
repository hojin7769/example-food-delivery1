package examplefooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyDeliveryInfo_table")
@Data
public class MyDeliveryInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String foodId;
    private String status;
}
