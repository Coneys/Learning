package patterns.structural.composite

import patterns.structural.bridge.inRealCode.*


class PaymentOrValidation(val first: PaymentValidation, val second: PaymentValidation) : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return first.validate(payment) or second.validate(payment)
    }
}

infix fun PaymentValidation.or(other: PaymentValidation) = PaymentOrValidation(this, other)

class GermanyOnlyPaymentValidation : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return payment.to.country == "Germany"
    }
}


fun main() {

    val firstPayment = Payment(800, Addressee("Abc", "Poland"))
    val secondPayment = Payment(1200, Addressee("Abc", "Germany"))

    val validation = SmallPaymentValidation() or GermanyOnlyPaymentValidation()

    val process = PaymentProcess(validation, PayuExecution())

    println(process.validate(firstPayment))
    println(process.validate(secondPayment))

}