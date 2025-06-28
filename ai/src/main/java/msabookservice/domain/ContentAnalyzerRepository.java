package msabookservice.domain;

import msabookservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "contentAnalyzers",
    path = "contentAnalyzers"
)
public interface ContentAnalyzerRepository
    extends PagingAndSortingRepository<ContentAnalyzer, Long> {}
