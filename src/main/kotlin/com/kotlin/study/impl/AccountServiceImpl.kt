package com.kotlin.study.impl

import com.kotlin.study.domain.Account
import com.kotlin.study.mapper.depositAccountToAccountResponse
import com.kotlin.study.repository.AccountRepository
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse
import com.kotlin.study.service.AccountService
import com.kotlin.study.util.TransactionType
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
) : AccountService {

    override fun deposit(accountRequest: AccountRequest): AccountDepositResponse {

        accountRequest.transactionType = TransactionType.DEPOSIT

            val account: Account = depositInAccount(accountRepository.findById(accountRequest.idAccount).get(),
                accountRequest.depositValue)
            return depositAccountToAccountResponse(account, accountRequest)

    }

    fun depositInAccount(account: Account, depositValue: Float): Account {
        account.balance += depositValue

        return accountRepository.save(account)
    }

    fun withdrawFromAccount(account: Account, depositValue: Float): Account {
        account.balance -= depositValue

        return accountRepository.save(account)
    }
}