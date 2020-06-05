package ch.section11.efraud.analyzer.boundary;

import ch.section11.efraud.analyzer.entity.ScoreRequest;
import ch.section11.efraud.events.control.ScoreRequests;
import ch.section11.efraud.events.entity.ScoreRequestInfo;

import javax.inject.Inject;

public class ScoreRequestCommandService {

    @Inject
    ScoreRequests requests;

    public void initScoreRequest(final ScoreRequestInfo scoreRequestInfo){
        //TODO publish event
    }

    public void startProcess(ScoreRequestInfo scoreRequestInfo) {
    }
}
