package com.common.demo.config

import com.common.demo.services.Handler
import com.common.demo.services.handers.LengthHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class HandlerConfig(
    private val lengthHandler: LengthHandler
) {

    @Bean
    @Primary
    fun handler(): Handler {
        return lengthHandler
    }
}