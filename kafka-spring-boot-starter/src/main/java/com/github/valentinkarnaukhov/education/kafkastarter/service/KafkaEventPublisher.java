package com.github.valentinkarnaukhov.education.kafkastarter.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Collection;
import java.util.UUID;

public class KafkaEventPublisher<EventType> {

    public ListenableFuture<SendResult<UUID, EventType>> send(UUID key, Collection<Header> headers, EventType value) {
        ProducerRecord<UUID, EventType> producerRecord = new ProducerRecord<>(getTopicName(), null, key, value, headers);
        return getKafkaTemplate().send(producerRecord);
    }

    public ListenableFuture<SendResult<UUID, EventType>> send(EventType value) {
        return send(null, null, value);
    }

    protected KafkaTemplate<UUID, EventType> getKafkaTemplate() {
        return null;
    }

    protected String getTopicName() {
        return null;
    }

}
