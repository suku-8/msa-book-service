package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "coverDesigns",
    path = "coverDesigns"
)
public interface CoverDesignRepository
    extends PagingAndSortingRepository<CoverDesign, Long> {}
