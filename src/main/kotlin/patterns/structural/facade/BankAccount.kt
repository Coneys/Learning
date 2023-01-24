package patterns.structural.facade

import patterns.structural.facade.internal.*
import patterns.structural.facade.internal.CurrencyExchange

class BankAccount {
    private val currentBalance = Money(100, "EUR")

    private val fraudDetector = FraudDetector()
    private val currencyExchange = CurrencyExchange()
    private val notificationService = NotificationService()
    private val atmValidator = ATMValidator()
    private val withdrawValidator = WithdrawValidator()


    fun withdraw(user: Int, money: Money, from: ATM) {
        if (fraudDetector.isFraud(user)) {
            ///
        }

        if (atmValidator.isValid(from).not()) {
            ///
        }

        val toWithdraw = currencyExchange.exchangeTo(money, currentBalance.currency)

        if (withdrawValidator.validate(toWithdraw, user).not()) {
            ///
        }

        notificationService.notify("Xxx", user)

        updateBalance()

    }

    private fun updateBalance() {
        ///
    }
}