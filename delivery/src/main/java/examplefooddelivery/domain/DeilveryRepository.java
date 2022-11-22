package examplefooddelivery.domain;

import examplefooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "deilveries",
    path = "deilveries"
)
public interface DeilveryRepository
    extends PagingAndSortingRepository<Deilvery, Long> {}
