package com.kotlin.study.domain

import com.kotlin.study.util.AccountType
import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Account(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAccount: Long,
    val idPersonFK: Long,
    val balance: Float,
    val dailyWithdrawLimit: Float,
    val active: Boolean,
    val accountType: AccountType,
    val creationDate: ZonedDateTime
)