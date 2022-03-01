package com.kotlin.study.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.kotlin.study.util.TransactionType

data class AccountWithdrawResponse(
    @JsonProperty("Account_Number")
    var idAccount: Long?,
    @JsonProperty("Transaction_Type")
    var transactionType: TransactionType = TransactionType.WITHDRAW,
    @JsonProperty("Amount_withdrawn")
    var withdraw: Float?,
    @JsonProperty("Client_Name")
    var destinationAccountPersonName: String?,
)