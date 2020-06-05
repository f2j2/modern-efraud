package ch.section11.efraud.events.entity;

import javax.json.JsonObject;
import java.util.UUID;

public class ScoreRequestInfo {

    private final UUID requestId;
    private final PaymentType paymentType;

    public ScoreRequestInfo(UUID requestId, final PaymentType paymentType) {
        this.requestId = requestId;
        this.paymentType = paymentType;
    }

    public ScoreRequestInfo(JsonObject jsonObject) {
        this(UUID.fromString(jsonObject.getString("requestId")), PaymentType.fromString(jsonObject.getString("paymentType")));
    }

    public UUID getRequestId() {
        return requestId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
