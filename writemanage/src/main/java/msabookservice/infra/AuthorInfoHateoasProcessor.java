package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuthorInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AuthorInfo>> {

    @Override
    public EntityModel<AuthorInfo> process(EntityModel<AuthorInfo> model) {
        return model;
    }
}
