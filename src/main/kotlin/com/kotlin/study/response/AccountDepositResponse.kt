package com.kotlin.study.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.kotlin.study.util.TransactionType

data class AccountDepositResponse (
    @JsonProperty("Account_Number")
    var idAccount: Long?,
    @JsonProperty("Transaction_Type")
    var transactionType: TransactionType?,
    @JsonProperty("Deposited_value")
    var depositValue: Float?,
    @JsonProperty("Client_Name")
    var destinationAccountPersonName: String?,
)