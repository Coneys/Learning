package patterns.structural.composite

import patterns.structural.bridge.inRealCode.*

class PaymentAndValidation(val first: PaymentValidation, val second: PaymentValidation) : PaymentValidation {
    override fun validate(payment: Payment): Boolean {
        return first.validate(payment) and second.validate(payment)
    }
}

infix fun PaymentValidation.and(other: PaymentValidation) = PaymentAndValidation(this, other)

fun onlySmallAmounts() = SmallPaymentValidation()
fun onlyToGermany() = GermanyOnlyPaymentValidation()
fun onlyToPoland() = PolandOnlyPaymentValidation()
fun onlyValidAmounts() = ValidAmountValidation()

fun main() {

    val validation = onlyValidAmounts() and onlyToGermany() or onlyToPoland() and onlySmallAmounts()

    val firstPayment = Payment(800, Addressee("Abc", "Poland"))
    val secondPayment = Payment(1200, Addressee("Abc", "Germany"))


    val process = PaymentProcess(validation, PayuExecution())

    println(process.validate(firstPayment))
    println(process.validate(secondPayment))

}