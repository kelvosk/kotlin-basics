package com.kotlin.study.controller

import com.kotlin.study.api.AccountControllerApi
import com.kotlin.study.impl.AccountServiceImpl
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController (
    private val accountServiceImpl: AccountServiceImpl
) : AccountControllerApi {

    override fun deposit(accountRequest: AccountRequest): AccountDepositResponse {
        return accountServiceImpl.deposit(accountRequest);
    }
}