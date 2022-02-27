package com.kotlin.study.request

import com.kotlin.study.util.AccountType
import com.kotlin.study.util.TransactionType

data class AccountRequest (
    val idAccount: Long,
    var transactionType: TransactionType?,
    val depositValue: Float = 0.0f,
    val withdrawValue: Float = 0.0f,
    val destinationAccountId: Long = 0,
    val accountType: AccountType = AccountType.LEGAL_PERSON,

    )