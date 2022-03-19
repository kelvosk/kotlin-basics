package com.kotlin.study.api

import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RequestMapping(value = ["/account"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Account")
interface AccountControllerApi {

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Deposit an amount in account")
    fun deposit(@RequestBody accountRequest: AccountRequest) : AccountDepositResponse

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get account balance")
    fun getBalance(@PathVariable id: Long) : AccountBalanceResponse

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Withdraw an amount from account")
    fun withdraw(@RequestBody accountRequest: AccountRequest) : AccountWithdrawResponse

    @PutMapping("/block")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Block an account")
    fun blockAccount(@RequestBody accountRequest: AccountRequest) : AccountBlockResponse

    @PutMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Active an account")
    fun activeAccount(@RequestBody accountRequest: AccountRequest) : AccountActiveResponse
}