package com.kotlin.study.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
data class InactiveError(override val message: String?) : RuntimeException() {

}