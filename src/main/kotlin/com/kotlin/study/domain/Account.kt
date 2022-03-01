package com.kotlin.study.domain

import com.kotlin.study.util.AccountType
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAccount: Long,
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "account")
    val person: Person?,
    var balance: Float = 1000.0f,
    var dailyWithdrawLimit: Float = 0.0f,
    var active: Boolean = true,
    val accountType: AccountType,
    var creationDate: LocalDateTime?,
)