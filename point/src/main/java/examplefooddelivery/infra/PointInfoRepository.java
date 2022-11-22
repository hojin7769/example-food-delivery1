package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "pointInfos",
    path = "pointInfos"
)
public interface PointInfoRepository
    extends PagingAndSortingRepository<PointInfo, Long> {}
