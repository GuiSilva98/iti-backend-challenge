package com.common.demo.usecase

import com.common.demo.services.Handler
import org.springframework.stereotype.Component

@Component
class ProcessPassword(
    private val handler: Handler
) {

    fun process(password: String): Boolean = handler.handle(password)
}