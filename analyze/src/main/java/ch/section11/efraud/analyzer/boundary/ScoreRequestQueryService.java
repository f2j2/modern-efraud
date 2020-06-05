package ch.section11.efraud.analyzer.boundary;

import ch.section11.efraud.analyzer.entity.ScoreRequest;
import ch.section11.efraud.events.control.ScoreRequests;

import javax.inject.Inject;
import java.util.UUID;

public class ScoreRequestQueryService {

    @Inject
    ScoreRequests requests;

    public ScoreRequest getScoreRequest(final UUID scoreRequestId) {
        return requests.get(scoreRequestId);
    }
}
