package ch.section11.efraud.analyzer.boundary;

import ch.section11.efraud.events.entity.ScoreResultProcessFinished;
import ch.section11.efraud.events.entity.ScoreResultProcessStarted;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
@Startup
public class ScoreRequestEventHandler {

    @Inject
    ScoreRequestCommandService scoreRequestCommandService;

    @Inject
    Logger logger;


    public void handle(@Observes ScoreResultProcessStarted event) {
        scoreRequestCommandService.startProcess(event.getScoreRequestInfo());
    }


    public void handle(@Observes ScoreResultProcessFinished event) {

    }

}
