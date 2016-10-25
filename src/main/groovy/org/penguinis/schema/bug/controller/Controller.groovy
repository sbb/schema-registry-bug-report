package org.penguinis.schema.bug.controller

import org.penguinis.schema.bug.domain.MessageType
import org.penguinis.schema.bug.source.MySource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sbyrne on 10/14/16.
 */
@RestController
class Controller {

    private final MySource source

    @Autowired
    Controller(MySource source) {
        this.source = source
    }

    @GetMapping('/send/{name}')
    private void addStruct(@PathVariable String name) {
        source.input().send(MessageBuilder.withPayload(new MessageType("example at ${new Date()}", name)).build())
    }
}
