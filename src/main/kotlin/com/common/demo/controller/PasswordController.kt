package com.common.demo.controller

import com.common.demo.usecase.ProcessPassword
import org.springframework.http.HttpStatus.NOT_ACCEPTABLE
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
    private val processPassword: ProcessPassword
) {

    @GetMapping("/{password}")
    @ResponseStatus(OK)
    fun validatePassword(@PathVariable password: String): ResponseEntity<Boolean> {
        val result = processPassword.process(password)
        return if (!result) {
            ResponseEntity(false, NOT_ACCEPTABLE)
        } else
            ResponseEntity(true, OK)
    }
}