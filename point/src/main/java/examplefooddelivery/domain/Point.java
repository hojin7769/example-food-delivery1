package examplefooddelivery.domain;

import examplefooddelivery.PointApplication;
import examplefooddelivery.domain.UpPointed;
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

        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

    }
}
