package org.acme.kafka;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class Fruit1Deserializer extends JsonbDeserializer<Fruit1> {
    public Fruit1Deserializer() {
        // pass the class to the parent.
        super(Fruit1.class);
    }
}
