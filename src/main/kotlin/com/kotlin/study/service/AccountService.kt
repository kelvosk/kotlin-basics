package com.kotlin.study.service

import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.*
import org.springframework.stereotype.Service

@Service
interface AccountService {
    fun deposit(accountRequest: AccountRequest) : AccountDepositResponse
    fun isActive(accountRequest: AccountRequest) : Boolean
    fun getBalance(accountRequest: AccountRequest) : AccountBalanceResponse
    fun withdraw(accountRequest: AccountRequest): AccountWithdrawResponse
    fun blockAccount(accountRequest: AccountRequest) : AccountBlockResponse
    fun activeAccount(accountRequest: AccountRequest) : AccountActiveResponse
}