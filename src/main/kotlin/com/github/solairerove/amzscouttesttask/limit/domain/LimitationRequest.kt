package com.github.solairerove.amzscouttesttask.limit.domain

import java.time.Instant

data class LimitationRequest(
    val time: Instant,
    val hostname: String
)
