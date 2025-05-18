package com.common.demo.controller

import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.OK
import kotlin.test.Test

@WireMockTest
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PasswordControllerTest {

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    companion object {
        private const val VALID_PASSWORD = "AbTp9!fok"
        private const val INVALID_PASSWORD = "AbTp9! foA"
    }

    @Test
    fun `should return true when validate a password`() {
        val result = testRestTemplate.getForEntity(
            "/validate/passwords/$VALID_PASSWORD",
            Boolean::class.java
        )

        assertThat(result.body).isNotNull.isTrue
        assertThat(result.statusCode).isEqualTo(OK)
    }

    @Test
    fun `should return false when validate a password`() {
        val result = testRestTemplate.getForEntity(
            "/validate/passwords/$INVALID_PASSWORD",
            Boolean::class.java
        )

        assertThat(result.body).isNotNull.isFalse
        assertThat(result.statusCode).isEqualTo(BAD_REQUEST)
    }

}