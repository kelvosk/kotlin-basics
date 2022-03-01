package com.kotlin.study.error

import java.lang.RuntimeException

class NotEnoughBalanceError(message: String) : RuntimeException(message)