package com.common.demo.services

abstract class Handler {

    protected var next: Handler? = null

    fun nextHandle(next: Handler?) {
        this.next = next
    }

    abstract fun handle(password: String): Boolean
}