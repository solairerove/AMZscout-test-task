package com.github.solairerove.amzscouttesttask

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

// вообще я использую котест, но спринг инишилайзер добавил жюнит, поэтому вот
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class ApplicationTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun shouldReturnDefaultMessage() {
        mockMvc.get("/api/v1/hello")
            .andExpect {
                status { status().isOk }
                content { contentType(MediaType.APPLICATION_JSON) }
                content { MockMvcResultMatchers.jsonPath("$.name", containsString("Mikita")) }
            }
    }
}
