package com.kotlin.study.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountActiveResponse (
    @JsonProperty("Account_Number")
    var idAccount: Long,
    val message: String = "This account is now activated"
)