package examplefooddelivery.domain;

import examplefooddelivery.FrontApplication;
import examplefooddelivery.domain.OrderCancled;
import examplefooddelivery.domain.OrderPlaced;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String foodId;

    @Embedded
    private String adress;

    @ElementCollection
    private List<String> options;

    private String status;

    private String price;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        examplefooddelivery.external.Payment payment = new examplefooddelivery.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext
            .getBean(examplefooddelivery.external.PaymentService.class)
            .pay(payment);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void updateStatus(OrderReject orderReject) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderReject.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
