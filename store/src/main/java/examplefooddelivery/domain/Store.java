package examplefooddelivery.domain;

import examplefooddelivery.StoreApplication;
import examplefooddelivery.domain.CookFinished;
import examplefooddelivery.domain.CookStarted;
import examplefooddelivery.domain.OrderAccept;
import examplefooddelivery.domain.OrderReject;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String foodId;

    private String storeAdress;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderAccept orderAccept = new OrderAccept(this);
        orderAccept.setStatus("접수됨");
        orderAccept.publishAfterCommit();

        OrderReject orderReject = new OrderReject(this);
        orderReject.setStatus("취소됨");
        orderReject.publishAfterCommit();

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.setStatus("조리시작");
        cookStarted.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.setStatus("조리끝");
        cookFinished.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public static void 주문정보추가(Paid paid) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        Store store = new Store();
        store.setOrderId(paid.getOrderId());
        store.setStatus("결제됨");
        repository().save(store);



        

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */
    }

    public static void 주문취소알림(OrderCancled orderCancled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }
}
