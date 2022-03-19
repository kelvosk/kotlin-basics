package com.kotlin.study.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Transaction (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTransaction: Long = 0,
    var idAccount: Long,
    var transactionValue: Float,
    var transactionDate: LocalDateTime,
    var transactionType: String,
)