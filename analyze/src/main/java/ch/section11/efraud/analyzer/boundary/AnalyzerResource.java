package ch.section11.efraud.analyzer.boundary;

import ch.section11.efraud.analyzer.entity.ScoreRequest;
import ch.section11.efraud.events.entity.PaymentType;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.UUID;

@Path("analyze")
public class AnalyzerResource {

    @Context
    UriInfo uriInfo;

    @POST
    public Response score(JsonObject scoreRequest) {
        final PaymentType paymentType = PaymentType.fromString(scoreRequest.getString("paymentType", null));
        if (paymentType == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        final UUID requestId = UUID.randomUUID();
        //commandService
        final URI uri = uriInfo.getRequestUriBuilder().path(AnalyzerResource.class, "getScoreResult").build(requestId);
        return Response.accepted().header(HttpHeaders.LOCATION, uri).build();
    }


    @GET
    @Path("{id}")
    public JsonObject getScoreResult(@PathParam("id") UUID requestId) {
        final ScoreRequest request = null ; //queryService.getScoreRequest(requestId);
        if (request==null)
            throw new NotFoundException();

        return Json.createObjectBuilder()
                .add("status", request.getState().name().toLowerCase())
                .add("paymentType", request.getRequestInfo().getPaymentType().name().toLowerCase())
                .build();
    }

}
