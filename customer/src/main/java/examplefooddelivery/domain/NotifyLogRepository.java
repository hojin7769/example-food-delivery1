package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "notifyLogs",
    path = "notifyLogs"
)
public interface NotifyLogRepository
    extends PagingAndSortingRepository<NotifyLog, Long> {}
