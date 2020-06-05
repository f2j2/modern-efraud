package ch.section11.efraud.events.entity;

import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;
import java.util.Objects;

public abstract class ScoreRequestEvent {

    @JsonbProperty
    private final Instant instant;

    protected ScoreRequestEvent() {
        this.instant = Instant.now();
    }

    protected ScoreRequestEvent(Instant instant) {
        Objects.requireNonNull(instant);
        this.instant = instant;
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreRequestEvent that = (ScoreRequestEvent) o;
        return Objects.equals(instant, that.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant);
    }
}
