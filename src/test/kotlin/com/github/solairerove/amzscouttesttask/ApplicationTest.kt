package com.github.solairerove.amzscouttesttask

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.mock.http.server.reactive.MockServerHttpRequest.get
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

// вообще я использую котест, но спринг инишилайзер добавил жюнит, поэтому вот
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class ApplicationTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun shouldReturnDefaultMessage() {
        mockMvc.get("/api/v1/hello")
            .andExpect {
                status { status().isOk }
                content { MockMvcResultMatchers.jsonPath("$.name", containsString("Mikita")) }
            }
    }

    @Test
    fun shouldReturn200Status() {
        mockMvc.get("/api/v1/limitation").andExpect { status { status().isOk } }
    }

    @Test
    fun shouldReturn502StatusSynchronized() {
        mockMvc.get("/api/v1/limitation") {
            header("Host", "bad-gateway")
        }.andExpect { status { status().isOk } }

        mockMvc.get("/api/v1/limitation") {
            header("Host", "bad-gateway")
        }.andExpect { status { status().isOk } }

        mockMvc.get("/api/v1/limitation") {
            header("Host", "bad-gateway")
        }.andExpect { status { status().isOk } }

        mockMvc.get("/api/v1/limitation") {
            header("Host", "bad-gateway")
        }.andExpect { status { status().isBadGateway } }
    }
}
