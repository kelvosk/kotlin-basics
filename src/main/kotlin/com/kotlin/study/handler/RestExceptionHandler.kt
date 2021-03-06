package com.kotlin.study.handler

import com.kotlin.study.error.AccountNotFoundError
import com.kotlin.study.error.InactiveError
import com.kotlin.study.error.NotEnoughBalanceError
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(AccountNotFoundError::class)
    fun handleAccountNotFound(e: AccountNotFoundError, request: WebRequest) : ResponseEntity<*> {
        val exceptionResponse = ExceptionResponse(status = HttpStatus.NOT_FOUND, message = listOf(e.message!!)).toJson()
        return handleExceptionInternal(e, exceptionResponse, HttpHeaders(), HttpStatus.NOT_FOUND, request)
    }

    @ExceptionHandler(InactiveError::class, NotEnoughBalanceError::class)
    fun handleInactiveError(e: InactiveError, request: WebRequest) : ResponseEntity<*> {
        val exceptionResponse = ExceptionResponse(status = HttpStatus.NOT_ACCEPTABLE, message = listOf(e.message!!)).toJson()
        return handleExceptionInternal(e, exceptionResponse, HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request)
    }
}