package com.kotlin.study.api

import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RequestMapping(value = ["/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
interface AccountControllerApi {

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.OK)
    fun deposit(@RequestBody accountRequest: AccountRequest) : AccountDepositResponse

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBalance(@PathVariable id: Long) : AccountBalanceResponse

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.OK)
    fun withdraw(@RequestBody accountRequest: AccountRequest) : AccountWithdrawResponse

    @PutMapping("/block")
    @ResponseStatus(HttpStatus.OK)
    fun blockAccount(@RequestBody accountRequest: AccountRequest) : AccountBlockResponse

    @PutMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    fun activeAccount(@RequestBody accountRequest: AccountRequest) : AccountActiveResponse
}