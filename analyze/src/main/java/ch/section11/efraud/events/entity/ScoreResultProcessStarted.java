package ch.section11.efraud.events.entity;

import javax.json.JsonObject;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;

public class ScoreResultProcessStarted extends ScoreRequestEvent {

    @JsonbProperty
    private final ScoreRequestInfo scoreRequestInfo;

    public ScoreResultProcessStarted(final ScoreRequestInfo scoreRequestInfo) {
        this.scoreRequestInfo = scoreRequestInfo;
    }

    public ScoreResultProcessStarted(Instant instant, final ScoreRequestInfo scoreRequestInfo) {
        super(instant);
        this.scoreRequestInfo = scoreRequestInfo;
    }

    public ScoreResultProcessStarted(JsonObject jsonObject) {
        this(Instant.parse(jsonObject.getString("instant")), new ScoreRequestInfo(jsonObject.getJsonObject("scoreRequestInfo")));
    }

    public ScoreRequestInfo getScoreRequestInfo() {
        return scoreRequestInfo;
    }
}
