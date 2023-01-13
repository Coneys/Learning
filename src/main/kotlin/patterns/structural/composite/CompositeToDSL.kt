package patterns.structural.composite

import patterns.structural.bridge.inRealCode.*

infix fun PaymentValidation.and(other: PaymentValidation): PaymentValidation {
    return PaymentValidation { payment -> validate(payment) && other.validate(payment) }
}

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