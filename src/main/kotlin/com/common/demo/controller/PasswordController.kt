package com.common.demo.controller

import com.common.demo.service.ValidatePassword
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/validate/passwords")
class PasswordController(
    private val validatePassword: ValidatePassword
) {

    @GetMapping("/{password}")
    @ResponseStatus(OK)
    fun validatePassword(@PathVariable password: String): ResponseEntity<Boolean> {
        val result = validatePassword.validate(password)
        return buildResponseEntity(result)
    }

    private fun buildResponseEntity(result: Boolean): ResponseEntity<Boolean> =
        if (result) responseEntitySuccess() else responseEntityFail()

    private fun responseEntitySuccess() = ResponseEntity(true, OK)

    private fun responseEntityFail() = ResponseEntity(false, BAD_REQUEST)
}