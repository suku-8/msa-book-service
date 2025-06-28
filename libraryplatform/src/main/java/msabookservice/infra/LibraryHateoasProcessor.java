package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LibraryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Library>> {

    @Override
    public EntityModel<Library> process(EntityModel<Library> model) {
        return model;
    }
}
