package com.kotlin.study.impl

import com.kotlin.study.domain.Account
import com.kotlin.study.error.AccountError
import com.kotlin.study.mapper.depositAccountToAccountResponse
import com.kotlin.study.repository.AccountRepository
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.response.AccountDepositResponse
import com.kotlin.study.service.AccountService
import com.kotlin.study.error.InactiveError
import com.kotlin.study.util.TransactionType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
) : AccountService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun deposit(accountRequest: AccountRequest): AccountDepositResponse {
        logger.info("L=I C=AccountServiceImpl M=deposit " +
                "D=Depositing ${accountRequest.depositValue} into account ${accountRequest.idAccount}")

        return try {
            accountRequest.transactionType = TransactionType.DEPOSIT

            val account: Account = depositInAccount(accountRepository.getById(accountRequest.idAccount),
                accountRequest.depositValue)
            depositAccountToAccountResponse(account, accountRequest)

        } catch (e: Exception) {
            logger.info("L=E C=AccountServiceImpl M=deposit E=AccountError")
            throw AccountError("Error while depositing")
        }
    }

    override fun isActive(accountRequest: AccountRequest): Boolean {
        logger.info("L=I C=AccountServiceImpl M=isActive D=Verify if the account is activated")
        return when ((accountRepository.getById(accountRequest.idAccount).active)){
            true -> true
            false -> throw InactiveError()
        }

    }

    fun depositInAccount(account: Account, depositValue: Float): Account {
        logger.info("L=I C=AccountServiceImpl M=depositInAccount D=Adding value to account balance")
        account.balance += depositValue
        return accountRepository.save(account)
    }

    fun transferBalance(accountToSubtract: Account, accountToAdd: Account ,value: Float) {
        logger.info("L=I C=AccountServiceImpl M=transferBalance " +
                "D=Transferring value from account ID ${accountToSubtract.idAccount} to ${accountToAdd.idAccount}")
        accountToSubtract.balance -= value
        accountToAdd.balance += value
        accountRepository.save(accountToSubtract)
        accountRepository.save(accountToAdd)

    }

}