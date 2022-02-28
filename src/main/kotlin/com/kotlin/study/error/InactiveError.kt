package com.kotlin.study.error

import java.lang.RuntimeException

class InactiveError() : RuntimeException("This account is inactive, please contact the bank") {

}