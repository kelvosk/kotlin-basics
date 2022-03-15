package com.kotlin.study.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
data class AccountNotFoundError(override val message: String?) : RuntimeException()