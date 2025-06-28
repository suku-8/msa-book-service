package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CoverDesignHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CoverDesign>> {

    @Override
    public EntityModel<CoverDesign> process(EntityModel<CoverDesign> model) {
        return model;
    }
}
