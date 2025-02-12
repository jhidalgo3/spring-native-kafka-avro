package com.sample.config;

import org.apache.kafka.common.security.authenticator.AbstractLogin;
import org.apache.kafka.common.security.authenticator.AbstractLogin.DefaultLoginCallbackHandler;
import org.apache.kafka.common.security.authenticator.DefaultLogin;
import org.apache.kafka.common.security.authenticator.SaslClientCallbackHandler;
import org.apache.kafka.common.security.plain.PlainLoginModule;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.errors.DefaultProductionExceptionHandler;
import org.apache.kafka.streams.errors.LogAndFailExceptionHandler;
import org.apache.kafka.streams.processor.FailOnInvalidTimestamp;
import org.apache.kafka.streams.processor.internals.StreamsPartitionAssignor;
import org.apache.kafka.streams.processor.internals.assignment.FallbackPriorTaskAssignor;
import org.apache.kafka.streams.processor.internals.assignment.HighAvailabilityTaskAssignor;
import org.apache.kafka.streams.processor.internals.assignment.StickyTaskAssignor;
import org.glassfish.jersey.internal.RuntimeDelegateImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

import com.sample.avro.Address;

import io.confluent.kafka.schemaregistry.client.rest.entities.ErrorMessage;
import io.confluent.kafka.schemaregistry.client.rest.entities.SchemaString;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

@Configuration
@NativeHint(
        types = @TypeHint(types = {
        		PlainLoginModule.class,
        		DefaultLogin.class,
        		AbstractLogin.class,
        		DefaultLoginCallbackHandler.class,
        	SaslClientCallbackHandler.class,
                StreamsPartitionAssignor.class,
                DefaultProductionExceptionHandler.class,
                FailOnInvalidTimestamp.class,
                HighAvailabilityTaskAssignor.class,
                StickyTaskAssignor.class,
                FallbackPriorTaskAssignor.class,
                TopicNameStrategy.class,
                LogAndFailExceptionHandler.class,
                SpecificAvroSerde.class,
                KafkaAvroSerializer.class,
                ErrorMessage.class,
                SchemaString.class
        })
)

@TypeHint(types = Serdes.class,
        typeNames = {
                "org.apache.kafka.common.serialization.Serdes$StringSerde",
                "org.apache.kafka.common.serialization.Serdes$ByteArraySerde"
        })
@TypeHint(types = RuntimeDelegateImpl.class)

@TypeHint(types = Address.class)

public class AotConfig {
}
