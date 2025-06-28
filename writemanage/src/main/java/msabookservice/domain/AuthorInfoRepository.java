package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "authorInfos",
    path = "authorInfos"
)
public interface AuthorInfoRepository
    extends PagingAndSortingRepository<AuthorInfo, Long> {}
