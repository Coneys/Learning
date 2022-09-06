package patterns.structural.builder

fun main() {
    val customer = CustomerAssembler("Jan", 20).apply {
        creditScore = 20
        occupation = "unknown"
        city = "Krakow"
    }.assembly()

    println("Immutable customer created by assembler $customer")

    val dslCustomer = customerWith("Marek", 33) {
        occupation = "some"
        city = "Warsow"
        creditScore = 30
    }


    println("Immutable customer created by dsl $dslCustomer")


}