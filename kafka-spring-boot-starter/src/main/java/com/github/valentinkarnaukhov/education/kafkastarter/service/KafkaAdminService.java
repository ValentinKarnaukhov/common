package com.github.valentinkarnaukhov.education.kafkastarter.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaAdminService {

    public NewTopic createNewTopic(String topicName, Integer partitions, Integer replicas) {
        return TopicBuilder.name(topicName)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }

    public NewTopic createNewTopic(String topicName) {
        return createNewTopic(topicName, 1, 0);
    }

}
