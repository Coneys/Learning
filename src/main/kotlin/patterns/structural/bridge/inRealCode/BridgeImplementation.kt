package patterns.structural.bridge.inRealCode

interface PaymentValidation {
    fun validate(payment: Payment): Boolean
}

interface PaymentExecution {
    fun execute(payment: Payment): Boolean
}

class StandardUserValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.amount < 1000 && payment.to.country == "Poland"
    }
}

class VipUserValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.to.country != "Russia"
    }
}

class PayuExecution : PaymentExecution {
    override fun execute(payment: Payment): Boolean {
        // send to PayU with http
        return true
    }
}

class Przelewy24Execution : PaymentExecution {
    override fun execute(payment: Payment): Boolean {
        // send to Przelewy24 with http
        return true
    }
}

class Przelewy24ExpressExecution : PaymentExecution {
    override fun execute(payment: Payment): Boolean {
        // send to Przelewy24 with http using Express endpoint
        return true
    }
}


class PaymentProcess2(val validation: PaymentValidation, val execution: PaymentExecution)

fun main() {

    val payuStandardProcess = PaymentProcess2(StandardUserValidation(), PayuExecution())
    val payuVipProcess = PaymentProcess2(VipUserValidation(), PayuExecution())
    val przelewy24StandardProcess = PaymentProcess2(StandardUserValidation(), Przelewy24Execution())
    val przelewy24ExpressStandardProcess = PaymentProcess2(StandardUserValidation(), Przelewy24ExpressExecution())


}