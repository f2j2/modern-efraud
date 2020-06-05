package ch.section11.efraud.events.entity;

import javax.json.JsonObject;
import java.time.Instant;
import java.util.UUID;

public class ScoreRequestProcessed extends ScoreRequestEvent {
    private final UUID scoreRequestId;

    public ScoreRequestProcessed(Instant instant, UUID scoreRequestId) {
        super(instant);
        this.scoreRequestId = scoreRequestId;
    }

    public ScoreRequestProcessed(JsonObject jsonObject) {

        this(Instant.parse(jsonObject.getString("instant")), UUID.fromString(jsonObject.getString("scoreRequestId")));
    }

    public UUID getScoreRequestId() {
        return scoreRequestId;
    }
}
