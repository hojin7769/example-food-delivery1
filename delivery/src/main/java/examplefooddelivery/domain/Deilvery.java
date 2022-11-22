package examplefooddelivery.domain;

import examplefooddelivery.DeliveryApplication;
import examplefooddelivery.domain.Delivered;
import examplefooddelivery.domain.Picked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Deilvery_table")
@Data
public class Deilvery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private String orderId;

    @PostPersist
    public void onPostPersist() {
        Picked picked = new Picked(this);
        picked.publishAfterCommit();

        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();
    }

    public static DeilveryRepository repository() {
        DeilveryRepository deilveryRepository = DeliveryApplication.applicationContext.getBean(
            DeilveryRepository.class
        );
        return deilveryRepository;
    }

    public static void 배달목록추가(CookFinished cookFinished) {
        /** Example 1:  new item 
        Deilvery deilvery = new Deilvery();
        repository().save(deilvery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(deilvery->{
            
            deilvery // do something
            repository().save(deilvery);


         });
        */

    }
}
