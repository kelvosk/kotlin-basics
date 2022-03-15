package com.kotlin.study.util

enum class TransactionType(
    val id: Long,
    val description: String
){
    DEPOSIT(1, "Deposit"),
    WITHDRAW(2, "Withdraw"),
    TRANSFER(3, "Transfer"),
    BALANCE(3, "Balance"),
}