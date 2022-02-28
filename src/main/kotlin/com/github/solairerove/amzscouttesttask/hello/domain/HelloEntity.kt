package com.github.solairerove.amzscouttesttask.hello.domain

import java.time.Instant

data class HelloEntity(
    val name: String,
    val hello: String,
    val timestamp: Instant
)
