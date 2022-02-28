package com.github.solairerove.amzscouttesttask.hello.service

import com.github.solairerove.amzscouttesttask.hello.domain.HelloEntity
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class DefaultHelloService : HelloService {

    override fun hello(): HelloEntity = HelloEntity(
        name = "Mikita",
        hello = "ну допустим привет",
        timestamp = Instant.now()
    )
}
