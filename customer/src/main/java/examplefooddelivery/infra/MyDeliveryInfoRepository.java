package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "myDeliveryInfos",
    path = "myDeliveryInfos"
)
public interface MyDeliveryInfoRepository
    extends PagingAndSortingRepository<MyDeliveryInfo, Long> {}
