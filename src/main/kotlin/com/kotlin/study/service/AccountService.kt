package com.kotlin.study.service

import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse
import org.springframework.stereotype.Service

@Service
interface AccountService {
    fun deposit(accountRequest: AccountRequest) : AccountDepositResponse
    fun isActive(accountRequest: AccountRequest) : Boolean
}