package msabookservice.infra;

import msabookservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyLibraryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<MyLibrary>> {

    @Override
    public EntityModel<MyLibrary> process(EntityModel<MyLibrary> model) {
        return model;
    }
}
