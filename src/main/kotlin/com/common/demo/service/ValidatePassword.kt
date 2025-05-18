package com.common.demo.service

import com.common.demo.usecase.StringValidation.Companion.validateString
import org.springframework.stereotype.Component

@Component
class ValidatePassword {

    fun validate(password: String): Boolean = validateString(password)
}