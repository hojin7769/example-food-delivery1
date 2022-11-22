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


    private String status;

    private String price;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        //  examplefooddelivery.external.Payment payment = new examplefooddelivery.external.Payment();
        //  payment.setOrderId(String.valueOf(id));
        // mappings goes here
        //  FrontApplication.applicationContext
        //     .getBean(examplefooddelivery.external.PaymentService.class)
        //      .pay(payment);

             try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.setStatus("접수됨");
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
        Order order = new Order();
        if(orderReject.getStatus().equals("취소됨")){
            order.setStatus("취소됨");
             repository().save(order);
        }
        

        /** Example 2:  finding and process
        
        repository().findById(orderReject.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
