package org.penguinis.schema.bug.source

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

/**
 * Created by sbyrne on 10/14/16.
 */
interface MySource {
    @Output
    MessageChannel input()
}

