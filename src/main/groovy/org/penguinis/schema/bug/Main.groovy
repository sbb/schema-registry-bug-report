package org.penguinis.schema.bug

import org.penguinis.schema.bug.source.MySource
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient

/**
 * Created by sbyrne on 10/14/16.
 */
@SpringBootApplication
@EnableBinding(MySource)
@EnableSchemaRegistryClient
class Main {

//    @Bean
//    SchemaRegistryClient schemaRegistryClient(SchemaRegistryClientProperties schemaRegistryClientProperties) {
//        ConfluentSchemaRegistryClient defaultSchemaRegistryClient = new ConfluentSchemaRegistryClient();
//        if (StringUtils.hasText(schemaRegistryClientProperties.getEndpoint())) {
//            defaultSchemaRegistryClient.setEndpoint(schemaRegistryClientProperties.getEndpoint());
//        }
//        defaultSchemaRegistryClient
//    }

    static void main(String[] args) {
        SpringApplication.run(Main, args)
    }
}
