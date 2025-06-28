package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class WriteHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Write>> {

    @Override
    public EntityModel<Write> process(EntityModel<Write> model) {
        return model;
    }
}
