package fr.gantoin.domain;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;

@Getter
public class JsonNodeAutoCloseable implements AutoCloseable {

    private final JsonNode jsonNode;

    public JsonNodeAutoCloseable(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public void close() {
        // Nothing to do here
    }
}
