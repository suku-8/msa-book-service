package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "writes", path = "writes")
public interface WriteRepository
    extends PagingAndSortingRepository<Write, Long> {}
