package com.github.solairerove.amzscouttesttask.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.solairerove.amzscouttesttask.domain.HelloEntity
import java.time.Instant

data class HelloResponse(
    @JsonProperty("name")
    val name: String,

    @JsonProperty("currTime")
    val time: Instant
)

fun HelloEntity.toDto() = HelloResponse(
    name = name,
    time = timestamp
)
