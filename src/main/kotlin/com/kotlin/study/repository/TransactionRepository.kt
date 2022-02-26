package com.kotlin.study.repository

import com.kotlin.study.domain.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository <Transaction, Long> {

}