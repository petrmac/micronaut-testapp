package com.petrmacek.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Message(int code, String message) {
}
