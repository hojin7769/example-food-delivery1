package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeilveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Deilvery>> {

    @Override
    public EntityModel<Deilvery> process(EntityModel<Deilvery> model) {
        return model;
    }
}
