package com.common.demo.usecase

class StringValidation {

    companion object {

        private const val SPECIAL_CHARACTERS = "[!@#$%^&*()-+]"

        private const val ALLOWED_SIZE = 9

        fun checkString(string: String): Boolean =
            sizeIsAllowed(string) &&
                    hasDigit(string) &&
                    hasLowerCase(string) &&
                    hasUpperCase(string) &&
                    !hasNotBlankSpaces(string) && // TODO: Revisar a inversão aqui
                    hasDuplicatedCharacter(string) &&
                    hasSpecialCharacter(string)

        fun hasDigit(string: String): Boolean = string.any { it.isDigit() }

        fun hasLowerCase(string: String): Boolean = string.any { it.isLowerCase() }

        fun hasUpperCase(string: String): Boolean = string.any { it.isUpperCase() }

        fun hasNotBlankSpaces(string: String): Boolean = string.any { it.isWhitespace() }

        fun sizeIsAllowed(string: String): Boolean = string.length >= ALLOWED_SIZE

        fun hasDuplicatedCharacter(string: String): Boolean = string.length == string.toSet().size

        fun hasSpecialCharacter(string: String): Boolean = string.contains(SPECIAL_CHARACTERS.toRegex())
    }
}