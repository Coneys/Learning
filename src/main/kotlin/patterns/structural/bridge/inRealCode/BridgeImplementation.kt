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


class PaymentProcess(private val validation: PaymentValidation, private val execution: PaymentExecution) {
    fun validate(payment: Payment) = validation.validate(payment)
}

fun main() {

    val payuStandardProcess = PaymentProcess(StandardUserValidation(), PayuExecution())
    val payuVipProcess = PaymentProcess(VipUserValidation(), PayuExecution())
    val przelewy24StandardProcess = PaymentProcess(StandardUserValidation(), Przelewy24Execution())
    val przelewy24ExpressStandardProcess = PaymentProcess(StandardUserValidation(), Przelewy24ExpressExecution())


}