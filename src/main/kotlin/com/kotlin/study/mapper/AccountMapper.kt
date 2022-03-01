package com.kotlin.study.mapper

import com.kotlin.study.domain.Account
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.*

fun depositAccountToAccountResponse(account: Account,
                                    accountRequest: AccountRequest) : AccountDepositResponse
= AccountDepositResponse(
    idAccount = account.idAccount,
    transactionType = accountRequest.transactionType,
    depositValue = accountRequest.depositValue,
    destinationAccountPersonName = account.person!!.name,
)

fun getBalanceAccountToAccountBalanceResponse(account: Account)
= AccountBalanceResponse(
    idAccount = account.idAccount,
    accountOwnerName = account.person!!.name,
    balance = account.balance,
)

fun withdrawAccountToAccountWithdrawResponse(account: Account,
                                             accountRequest: AccountRequest)
= AccountWithdrawResponse(
    idAccount = account.idAccount,
    withdraw = accountRequest.withdrawValue,
    destinationAccountPersonName = account.person!!.name,
)

fun blockAccountToAccountBlockResponse(account: Account) = AccountBlockResponse(
    idAccount = account.idAccount
)

fun activeAccountToAccountActiveResponse(account: Account) = AccountActiveResponse(
    idAccount = account.idAccount
)