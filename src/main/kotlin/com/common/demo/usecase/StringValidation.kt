package com.common.demo.usecase

import org.springframework.stereotype.Component

@Component
class StringValidation {

    companion object {

        private const val SPECIAL_CHARACTERS = "[!@#$%^&*()-+]"

        private const val ALLOWED_SIZE = 9

        fun validateString(string: String): Boolean =
            sizeIsAllowed(string) &&
                    hasNumber(string) &&
                    hasLowerCase(string) &&
                    hasUpperCase(string) &&
                    hasNoBlankSpaces(string) &&
                    hasNoDuplicatedCharacter(string) &&
                    hasSpecialCharacter(string)

        fun hasNumber(string: String): Boolean = string.any { it.isDigit() }

        fun hasLowerCase(string: String): Boolean = string.any { it.isLowerCase() }

        fun hasUpperCase(string: String): Boolean = string.any { it.isUpperCase() }

        fun hasNoBlankSpaces(string: String): Boolean = string.any { it.isWhitespace() }.not()

        fun sizeIsAllowed(string: String): Boolean = string.length >= ALLOWED_SIZE

        fun hasNoDuplicatedCharacter(string: String): Boolean = string.length == string.toSet().size

        fun hasSpecialCharacter(string: String): Boolean = string.contains(SPECIAL_CHARACTERS.toRegex())
    }
}