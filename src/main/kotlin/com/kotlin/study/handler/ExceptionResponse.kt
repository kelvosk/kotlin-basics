package com.kotlin.study.handler

import org.springframework.http.HttpStatus

class ExceptionResponse(
    private val status: HttpStatus,
    private val message: List<String>,
) {
    fun toJson(): String = formatError().toString()

    private fun formatError(): StringBuilder {
        return StringBuilder()
            .append("{")
            .append("\n")
            .append("\"error\":\"").append(status.value()).append("\"")
            .append(",")
            .append("\n")
            .append("\"message\":\"").append(message).append("\"")
            .append("\n")
            .append("}")
    }
}