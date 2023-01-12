package patterns.creational.assembler

fun main() {

        val customerAssembler = CustomerAssembler("Jan", 20)

        val customer = customerAssembler.apply {
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