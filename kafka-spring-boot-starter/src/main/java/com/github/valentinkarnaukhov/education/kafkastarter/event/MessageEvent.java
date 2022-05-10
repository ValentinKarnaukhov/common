package com.github.valentinkarnaukhov.education.kafkastarter.event;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class MessageEvent {

    private UUID companyUuid;
    private String text;
    private Instant timestamp;

}
