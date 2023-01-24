package com.example.config;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.model.Payment;

@Configuration
public class JsonProducerConfig {

	private final KafkaProperties kafkaProperties;
	
	public JsonProducerConfig(KafkaProperties kafkaProperties) {
		super();
		this.kafkaProperties = kafkaProperties;
	}

	@Bean
	ProducerFactory<String, Payment> jsonProducerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
	}
	
    @Bean
    KafkaTemplate<String, Payment> jsonKafkaTemplate(ProducerFactory<String, Payment> jsonProducerFactory) {
        return new KafkaTemplate<>(jsonProducerFactory);
    }
	
}
