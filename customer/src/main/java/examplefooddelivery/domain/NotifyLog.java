package examplefooddelivery.domain;

import examplefooddelivery.CustomerApplication;

import java.nio.channels.NotYetBoundException;
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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(orderPlaced.getId()));
        notifyLog.setMessage("주문됨");
        repository().save(notifyLog);

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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(orderAccept.getOrderId()));
        notifyLog.setMessage("접수됨");
        repository().save(notifyLog);

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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(orderReject.getOrderId()));
        notifyLog.setMessage("취소됨");
        repository().save(notifyLog);

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
        
        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(cookStarted.getOrderId()));
        notifyLog.setMessage("조리시작됨");
        repository().save(notifyLog);
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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(cookFinished.getOrderId()));
        notifyLog.setMessage("조리 끝");
        repository().save(notifyLog);

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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(picked.getOrderId()));
        notifyLog.setMessage("조리 끝");
        repository().save(notifyLog);

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

        NotifyLog notifyLog = new NotifyLog();
        notifyLog.setOrderId(String.valueOf(paid.getOrderId()));
        notifyLog.setMessage("결제완료");
        repository().save(notifyLog);

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(notifyLog->{
            
            notifyLog // do something
            repository().save(notifyLog);


         });
        */

    }
}
