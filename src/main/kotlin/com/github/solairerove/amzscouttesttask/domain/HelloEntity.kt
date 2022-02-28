package com.github.solairerove.amzscouttesttask.domain

import java.time.Instant

data class HelloEntity(
    val name: String,
    val hello: String,
    val timestamp: Instant
)
