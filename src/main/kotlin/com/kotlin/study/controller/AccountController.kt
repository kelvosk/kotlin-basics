package com.kotlin.study.controller

import com.kotlin.study.api.AccountControllerApi
import com.kotlin.study.impl.AccountServiceImpl
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountActiveResponse
import com.kotlin.study.response.AccountBalanceResponse
import com.kotlin.study.response.AccountDepositResponse
import com.kotlin.study.response.AccountWithdrawResponse
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController (
    private val accountServiceImpl: AccountServiceImpl
) : AccountControllerApi {

    override fun deposit(accountRequest: AccountRequest): AccountDepositResponse =
        accountServiceImpl.deposit(accountRequest)

    override fun getBalance(id: Long): AccountBalanceResponse =
        accountServiceImpl.getBalance(id)

    override fun withdraw(accountRequest: AccountRequest): AccountWithdrawResponse =
        accountServiceImpl.withdraw(accountRequest)

    override fun blockAccount(accountRequest: AccountRequest) =
        accountServiceImpl.blockAccount(accountRequest)

    override fun activeAccount(accountRequest: AccountRequest): AccountActiveResponse =
        accountServiceImpl.activeAccount(accountRequest)
}