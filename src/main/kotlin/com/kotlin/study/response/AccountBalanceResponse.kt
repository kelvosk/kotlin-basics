package com.kotlin.study.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountBalanceResponse (
    @JsonProperty("Account_Number")
    var idAccount: Long?,
    @JsonProperty("Client_Name")
    var accountOwnerName: String?,
    @JsonProperty("Balance")
    var balance: Float?,

)