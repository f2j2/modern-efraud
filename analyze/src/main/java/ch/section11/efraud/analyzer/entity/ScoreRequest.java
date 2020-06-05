package ch.section11.efraud.analyzer.entity;

import ch.section11.efraud.events.entity.ScoreRequestInfo;
import org.omg.CORBA.INITIALIZE;

public class ScoreRequest {

    private ScoreRequestState state;
    private ScoreRequestInfo requestInfo;

    public ScoreRequestInfo getRequestInfo() {
        return requestInfo;
    }

    public ScoreRequestState getState() {
        return state;
    }

    public void accept() {
        state = ScoreRequestState.ACCEPTED;
    }

    public void init(final ScoreRequestInfo requestInfo) {
        state = ScoreRequestState.INITIALIZED;
        this.requestInfo = requestInfo;
    }

    public void enrich() {
        state = ScoreRequestState.ENRICHED;
    }

    public void postprocess() {
        state = ScoreRequestState.POSTPROCESSED;
    }

    public void process() {
        state = ScoreRequestState.PROCESSED;
    }

    public void timeout() {
        state = ScoreRequestState.TIMEDOUT;
    }


    public enum ScoreRequestState{
        INITIALIZED,
        ACCEPTED,
        ENRICHED,
        PROCESSED,
        POSTPROCESSED,
        FINISHED,
        TIMEDOUT,
        CANCELLED
    }
}
