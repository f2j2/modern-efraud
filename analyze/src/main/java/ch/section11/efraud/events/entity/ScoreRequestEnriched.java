package ch.section11.efraud.events.entity;

import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;
import java.util.UUID;

public class ScoreRequestEnriched extends ScoreRequestEvent {

    private final UUID scoreRequestId;

    public ScoreRequestEnriched(Instant instant, UUID scoreRequestId) {
        super(instant);
        this.scoreRequestId = scoreRequestId;
    }

    public ScoreRequestEnriched(JsonObject jsonObject) {

        this(Instant.parse(jsonObject.getString("instant")), UUID.fromString(jsonObject.getString("scoreRequestId")));
    }

    public UUID getScoreRequestId() {
        return scoreRequestId;
    }
}
