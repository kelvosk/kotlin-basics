package com.kotlin.study.domain

import com.kotlin.study.util.AccountType
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAccount: Long,
    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    val idPerson: Person,
    val balance: Float = 0.0f,
    val dailyWithdrawLimit: Float = 0.0f,
    val active: Boolean = true,
    val accountType: AccountType,
    val creationDate: LocalDateTime = LocalDateTime.now()
)