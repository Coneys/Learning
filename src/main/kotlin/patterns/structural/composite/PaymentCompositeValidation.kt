package patterns.structural.composite

import patterns.structural.bridge.inRealCode.*


class PolandOnlyPaymentValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.to.country == "Poland"
    }
}

class SmallPaymentValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.amount < 1000
    }
}

class ValidAmountValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.amount > 0
    }
}

class CompositeValidation(private val Validations: List<PaymentValidation>) : PaymentValidation {
    constructor(vararg Validations: PaymentValidation) : this(Validations.toList())

    override fun validate(payment: Payment): Boolean {
        return Validations.all { it.validate(payment) }
    }
}

fun main() {
    val firstPayment = Payment(800, Addressee("Abc", "Poland"))
    val secondPayment = Payment(1200, Addressee("Abc", "Poland"))

    val composite = CompositeValidation(PolandOnlyPaymentValidation(), SmallPaymentValidation(), ValidAmountValidation())
    val paymentProcess = PaymentProcess(composite, PayuExecution())
    
    val firstResult = paymentProcess.validate(firstPayment)
    val secondResult = paymentProcess.validate(secondPayment)
    
    println("First result $firstResult")
    println("Second result $secondResult")

}