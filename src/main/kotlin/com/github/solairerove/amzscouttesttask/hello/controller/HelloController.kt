package com.github.solairerove.amzscouttesttask.hello.controller

import com.github.solairerove.amzscouttesttask.hello.dto.HelloResponse
import com.github.solairerove.amzscouttesttask.hello.dto.toDto
import com.github.solairerove.amzscouttesttask.hello.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1/hello"])
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping
    fun hello(): HelloResponse = helloService.hello().toDto()
}
