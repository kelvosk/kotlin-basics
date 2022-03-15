package com.kotlin.study.impl

import com.kotlin.study.domain.Account
import com.kotlin.study.error.AccountError
import com.kotlin.study.repository.AccountRepository
import com.kotlin.study.request.AccountRequest
import com.kotlin.study.service.AccountService
import com.kotlin.study.error.InactiveError
import com.kotlin.study.error.NotEnoughBalanceError
import com.kotlin.study.mapper.*
import com.kotlin.study.response.*
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
        isActive(accountRequest)
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

    override fun getBalance(id: Long): AccountBalanceResponse {
        logger.info("L=I C=AccountServiceImpl M=getBalance D=Get account balance")
        isActive(AccountRequest(idAccount = id,
            transactionType = TransactionType.BALANCE))
        return getBalanceAccountToAccountBalanceResponse(accountRepository.getById(id))
    }

    override fun withdraw(accountRequest: AccountRequest): AccountWithdrawResponse {
        logger.info("L=I C=AccountServiceImpl M=withdraw D=Withdraw an amount from an account")
        isActive(accountRequest)
        return withdrawAccountToAccountWithdrawResponse(withdrawBalance(accountRepository.getById(accountRequest.idAccount),
            accountRequest.withdrawValue), accountRequest)
    }

    override fun blockAccount(accountRequest: AccountRequest) : AccountBlockResponse {
        logger.info("L=I C=AccountServiceImpl M=blockAccount D=Deactivating an account")
        isActive(accountRequest)
        return blockAccountToAccountBlockResponse(activeOrBlockAccount(accountRequest, false))
    }

    override fun activeAccount(accountRequest: AccountRequest): AccountActiveResponse {
        logger.info("L=I C=AccountServiceImpl M=activeAccount D=Activating an account")
        return activeAccountToAccountActiveResponse(activeOrBlockAccount(accountRequest, true))
    }

    fun activeOrBlockAccount(accountRequest: AccountRequest, bool: Boolean): Account{
        val account: Account = accountRepository.getById(accountRequest.idAccount)
        account.active = bool
        return accountRepository.save(account)
    }

    fun depositInAccount(account: Account, depositValue: Float): Account {
        logger.info("L=I C=AccountServiceImpl M=depositInAccount D=Adding value to account balance")
        account.balance += depositValue
        return accountRepository.save(account)
    }

    fun withdrawBalance(account: Account, withdrawValue: Float) : Account {
        if(account.balance >= withdrawValue && withdrawValue > 0){
            account.balance -= withdrawValue
        } else if(withdrawValue <= 0){
            throw NotEnoughBalanceError("Please withdraw an amount higher than 0")
        }
        else {
            throw NotEnoughBalanceError("You don't have enough balance to withdraw")
        }
        return accountRepository.save(account)
    }

    override fun isActive(accountRequest: AccountRequest): Boolean {
        logger.info("L=I C=AccountServiceImpl M=isActive D=Verify if the account is activated")
        return when ((accountRepository.getById(accountRequest.idAccount).active)){
            true -> true
            false -> throw InactiveError()
        }
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