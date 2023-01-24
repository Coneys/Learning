package patterns.structural.facade.internal

import patterns.structural.facade.Money

internal class CurrencyExchange {
    fun exchangeTo(money: Money, currency: String): Money {
        // ...
        return money
    }
}