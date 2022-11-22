package examplefooddelivery.domain;

import examplefooddelivery.PointApplication;
import examplefooddelivery.domain.UpPointed;
import examplefooddelivery.domain.UsedPoint;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Point_table")
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long point;

    private String customerId;

    private String orderId;

    @PostPersist
    public void onPostPersist() {
        UpPointed upPointed = new UpPointed(this);
        upPointed.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        examplefooddelivery.external.Payment payment = new examplefooddelivery.external.Payment();
        // mappings goes here
        PointApplication.applicationContext
            .getBean(examplefooddelivery.external.PaymentService.class)
            .pay(payment);

        UsedPoint usedPoint = new UsedPoint(this);
        usedPoint.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    public static void point(Delivered delivered) {
        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        UpPointed upPointed = new UpPointed(point);
        upPointed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            UpPointed upPointed = new UpPointed(point);
            upPointed.publishAfterCommit();

         });
        */

    }
}
