package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "subscribers",
    path = "subscribers"
)
public interface SubscriberRepository
    extends PagingAndSortingRepository<Subscriber, Long> {}
