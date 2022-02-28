package com.kotlin.study.error

import java.lang.RuntimeException

class AccountError(message: String) : RuntimeException(message) {
}