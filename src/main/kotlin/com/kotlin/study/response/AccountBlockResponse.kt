package com.kotlin.study.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountBlockResponse (
    @JsonProperty("Account_Number")
    var idAccount: Long,
    val message: String = "This account is now blocked"
)