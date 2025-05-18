package com.common.demo.service

import com.common.demo.usecase.StringValidation.Companion.checkString
import org.springframework.stereotype.Service

@Service
class ProcessPassword {

    fun process(password: String): Boolean = checkString(password)
}