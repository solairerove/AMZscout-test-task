package com.github.solairerove.amzscouttesttask.limit.service

import com.github.solairerove.amzscouttesttask.limit.domain.LimitationRequest
import com.github.solairerove.amzscouttesttask.limit.properties.ApplicationProperties
import org.springframework.stereotype.Service

@Service
class DefaultLimitationService(
    private val applicationProperties: ApplicationProperties
) : LimitationService {

    override fun limit(req: LimitationRequest) {
        println(applicationProperties.limitCount)
        println(applicationProperties.timeout.limitTime)
    }
}
