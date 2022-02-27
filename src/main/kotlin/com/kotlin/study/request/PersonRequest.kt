package com.kotlin.study.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.kotlin.study.domain.Account

data class PersonRequest (
    @JsonProperty("name")
    val name: String,
    @JsonProperty("cpf")
    val cpf: String,
    @JsonProperty("bornDate")
    val bornDate: String,
    @JsonProperty("account")
    val account: Account
)