package com.github.solairerove.amzscouttesttask.limit.advice

import com.github.solairerove.amzscouttesttask.limit.exception.LimitationException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(LimitationException::class)
    fun handleLimitationException(ex: LimitationException, request: WebRequest): ResponseEntity<Any?> {
        logger.error { ex.message }
        return ResponseEntity(null, HttpStatus.BAD_GATEWAY)
    }
}
