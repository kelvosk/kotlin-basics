package com.kotlin.study.repository

import com.kotlin.study.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {

}