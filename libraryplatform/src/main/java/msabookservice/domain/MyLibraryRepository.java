package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "myLibraries",
    path = "myLibraries"
)
public interface MyLibraryRepository
    extends PagingAndSortingRepository<MyLibrary, Long> {}
