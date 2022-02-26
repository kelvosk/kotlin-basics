package com.kotlin.study.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Transaction (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTransaction: Long,
    val idAccount: Long,
    val transactionValue: Float,
    val transactionDate: ZonedDateTime
)