package com.common.demo.services.handers

import com.common.demo.services.Handler
import org.springframework.stereotype.Component

@Component
class LengthHandler: Handler() {

    override fun handle(password: String): Boolean {
        if (password.length >= 9) {
            return true
        } else {
            return false
        }
    }
}