package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ContentAnalyzerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ContentAnalyzer>> {

    @Override
    public EntityModel<ContentAnalyzer> process(
        EntityModel<ContentAnalyzer> model
    ) {
        return model;
    }
}
