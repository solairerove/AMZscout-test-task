package com.github.solairerove.amzscouttesttask.limit.service

import com.github.solairerove.amzscouttesttask.limit.domain.LimitationRequest
import com.github.solairerove.amzscouttesttask.limit.exception.LimitationException

interface LimitationService {

    @Throws(LimitationException::class)
    fun limit(req: LimitationRequest)
}
