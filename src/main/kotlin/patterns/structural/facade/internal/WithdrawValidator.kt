package patterns.structural.facade.internal

import patterns.structural.facade.Money

internal class WithdrawValidator {
    fun validate(toWithdraw: Money, user: Int): Boolean {
        return true
    }
}