package com.github.solairerove.amzscouttesttask.limit.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties(prefix = "amz.scout", ignoreInvalidFields = false)
class ApplicationProperties(
    val timeout: Timeout,
    val limitCount: Int
) {

    class Timeout(
        val limitTime: Duration
    )
}
