package ch.section11.efraud.events.entity;

import java.util.stream.Stream;

public enum PaymentType {
    INTERNATIONAL, INTERNAL, ACCOUNT, ADDRESS, UNKNOWN;

    public static PaymentType fromString(final String name) {
        return Stream.of(values()).filter(v -> v.name().equalsIgnoreCase(name)).findAny().orElse(null);
    }
}
