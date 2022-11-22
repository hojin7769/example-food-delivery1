package examplefooddelivery.infra;

import examplefooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class NotifyLogHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<NotifyLog>> {

    @Override
    public EntityModel<NotifyLog> process(EntityModel<NotifyLog> model) {
        return model;
    }
}
