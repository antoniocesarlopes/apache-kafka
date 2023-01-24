package com.example.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import com.example.util.Constantes.TOPICS;

@Configuration
public class KafkaAdminConfig {

	private final KafkaProperties kafkaProperties;

	public KafkaAdminConfig(KafkaProperties kafkaProperties) {
		super();
		this.kafkaProperties = kafkaProperties;
	}

    @Bean
    KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }
    
    @Bean
    KafkaAdmin.NewTopics createTopic() {
    	return new KafkaAdmin.NewTopics(TopicBuilder.name(TOPICS.PAYMENT).partitions(1).build());
    }
	
}
