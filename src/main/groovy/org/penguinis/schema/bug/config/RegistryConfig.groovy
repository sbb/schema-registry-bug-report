package org.penguinis.schema.bug.config

import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient
import org.springframework.cloud.stream.schema.client.config.SchemaRegistryClientProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.MimeType
import org.springframework.util.StringUtils

/**
 * Created by sbyrne on 10/25/16.
 */
@Configuration
class RegistryConfig {

    @Bean
    SchemaRegistryClient schemaRegistryClient(SchemaRegistryClientProperties schemaRegistryClientProperties) {
        ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
        if (StringUtils.hasText(schemaRegistryClientProperties.getEndpoint())) {
            client.setEndpoint(schemaRegistryClientProperties.getEndpoint());
        }
        client
    }

    @Bean
    AvroSchemaMessageConverter avroSchemaMessageConverter() {
        // For now, having this explicit mime type (instead of the default "application/avro"
        // seems to be required; the recipient does not seem to be able to handle
        // the incoming traffic if it's not with this mime type.
        return new AvroSchemaMessageConverter(MimeType.valueOf('application/*+avro'))
    }
}
