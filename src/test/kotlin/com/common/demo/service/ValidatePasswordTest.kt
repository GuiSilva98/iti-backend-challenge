package com.common.demo.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class ValidatePasswordTest {

    private val validatePassword = ValidatePassword()

    companion object {
        private const val VALID_PASSWORD = "AbTp9!fok"
    }

    @Test
    fun `should return true when password is valid`() {
        val result = validatePassword.validate(VALID_PASSWORD)

        assertThat(result).isNotNull().isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"])
    fun `should return false when password is not valid`(invalidPassword: String) {
        val result = validatePassword.validate(invalidPassword)

        assertThat(result).isNotNull().isFalse
    }
}