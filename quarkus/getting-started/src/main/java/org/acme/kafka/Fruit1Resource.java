package org.acme.kafka;

import io.smallrye.reactive.messaging.annotations.Channel;
import org.acme.mongodb.Fruit;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits1")
public class Fruit1Resource {
    
    @Inject
    @Channel("fruit-out")
    Publisher<Fruit> fruits;
    
    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<Fruit> stream() {
        return fruits;
    }
}
