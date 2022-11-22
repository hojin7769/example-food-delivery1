package examplefooddelivery.domain;

import examplefooddelivery.CustomerApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NotifyLog_table")
@Data
public class NotifyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String message;

    public static NotifyLogRepository repository() {
        NotifyLogRepository notifyLogRepository = CustomerApplication.applicationContext.getBean(
            NotifyLogRepository.class
        );
        return notifyLogRepository;
    }

    public static void appNotify(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(OrderAccept orderAccept) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccept.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(OrderReject orderReject) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderReject.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(CookStarted cookStarted) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(CookFinished cookFinished) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(Picked picked) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }

    public static void appNotify(Paid paid) {
        /** Example 1:  new item 
        NotifyLog notifyLog = new NotifyLog();
        repository().save(notifyLog);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }
}
