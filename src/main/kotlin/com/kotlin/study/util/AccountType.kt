package com.kotlin.study.util

enum class AccountType (
    val id: Long,
    val description: String
    ) {
    LEGAL_PERSON(1, "Legal Person"),
    JURISTIC_PERSON(2, "Juristic Person")

}