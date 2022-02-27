package com.kotlin.study.api

import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping(value = ["/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
interface AccountControllerApi {

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.OK)
    fun deposit(@RequestBody accountRequest: AccountRequest) : AccountDepositResponse
}