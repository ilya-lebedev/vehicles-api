package com.udacity.vehicles.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Available values for condition of a given car.
 */
public enum Condition {

    USED,
    NEW;

    @JsonCreator
    public static Condition fromString(String key) {
        for (Condition type : Condition.values()) {
            if (type.name().equalsIgnoreCase(key)) {
                return type;
            }
        }
        return null;
    }

}
