package com.kotlin.study.mapper

import com.kotlin.study.domain.Account
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse

fun depositAccountToAccountResponse(account: Account,
                                    accountRequest: AccountRequest) : AccountDepositResponse
= AccountDepositResponse(
    idAccount = account.idAccount,
    transactionType = accountRequest.transactionType,
    depositValue = accountRequest.depositValue,
    destinationAccountPersonName = account.person!!.name
)