package com.common.demo.usecase

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StringValidationTest {

    private val stringValidation = StringValidation

    companion object {
        private const val VALID_STRING = "AbTp9!fok"
    }

    @Test
    fun `should return true when string pass all scenarios`() {
        val password = buildPassword(null)

        val result = stringValidation.validateString(password)

        assertTrue { result }
    }

    @Test
    fun `should return false when string has not a number`() {
        val password = buildPassword("number")

        val result = stringValidation.hasNumber(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has not a lowercase character`() {
        val password = buildPassword("lowercase")

        val result = stringValidation.hasLowerCase(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has not a uppercase character`() {
        val password = buildPassword("uppercase")

        val result = stringValidation.hasUpperCase(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has a blank space`() {
        val password = buildPassword("blank")

        val result = stringValidation.hasNoBlankSpaces(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has not the size accepted`() {
        val password = buildPassword("size")

        val result = stringValidation.sizeIsAllowed(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has a duplicated character`() {
        val password = buildPassword("duplicated")

        val result = stringValidation.hasNoDuplicatedCharacter(password)

        assertFalse { result }
    }

    @Test
    fun `should return false when string has not a special character`() {
        val password = buildPassword("special")

        val result = stringValidation.hasSpecialCharacter(password)

        assertFalse { result }
    }

    private fun buildPassword(option: String?): String =
         when(option) {
            "number" -> "abcdefghij"
            "lowercase" -> "ABCDEFGHIJ"
            "uppercase" -> "abcdefghij"
            "blank" -> "abcd efghi"
            "size" -> "abcdefgh"
            "duplicated" -> "aabcdefghij"
            "special" -> "abcdefghij"
            else -> VALID_STRING
        }
}