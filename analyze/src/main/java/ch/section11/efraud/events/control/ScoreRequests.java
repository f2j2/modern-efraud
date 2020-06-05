package ch.section11.efraud.events.control;


import ch.section11.efraud.analyzer.entity.ScoreRequest;
import ch.section11.efraud.events.entity.ScoreRequestEnriched;
import ch.section11.efraud.events.entity.ScoreRequestInitialized;
import ch.section11.efraud.events.entity.ScoreRequestProcessed;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ScoreRequests {
    private Map<UUID, ScoreRequest> requestMap = new ConcurrentHashMap<>();

    public ScoreRequest get(final UUID requestId){
        return requestMap.get(requestId);
    }

    public void apply(@Observes ScoreRequestInitialized event) {
        requestMap.putIfAbsent(event.getScoreRequestInfo().getRequestId(), new ScoreRequest());
        applyFor(event.getScoreRequestInfo().getRequestId(), o -> o.init(event.getScoreRequestInfo()));
    }

    public void apply(@Observes ScoreRequestEnriched event) {
        applyFor(event.getScoreRequestId(), ScoreRequest::enrich);
    }

    public void apply(@Observes ScoreRequestProcessed event) {
        applyFor(event.getScoreRequestId(), ScoreRequest::process);
    }


    private void applyFor(final UUID requestId, final Consumer<ScoreRequest> consumer) {
        final ScoreRequest request =  requestMap.get(requestId);
        if (request!= null) {
            consumer.accept(request);
        }
    }

}
