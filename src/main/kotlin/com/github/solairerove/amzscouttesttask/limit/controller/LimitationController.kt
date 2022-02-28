package com.github.solairerove.amzscouttesttask.limit.controller

import com.github.solairerove.amzscouttesttask.limit.domain.LimitationRequest
import com.github.solairerove.amzscouttesttask.limit.service.LimitationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/api/v1/limitation")
class LimitationController(private val limitationService: LimitationService) {

    @GetMapping
    fun requestLimit() {
        limitationService.limit(
            LimitationRequest(
                time = Instant.now(),
                hostname = ""
            )
        )
    }
}
