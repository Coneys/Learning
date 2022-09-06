package patterns.creational.builder

data class Customer(
    val name: String,
    val age: Int,
    val city: String?,
    val occupation: String?,
    val creditScore: Int?
)

class CustomerAssembler(val name: String, val age: Int) {
    var city = ""
    var occupation: String? = null
    var creditScore: Int? = null

    fun assembly() = Customer(name, age, city, occupation, creditScore)
}

fun customerWith(name: String, age: Int, assembler: CustomerAssembler.() -> Unit): Customer {
    val customerAssembler = CustomerAssembler(name, age)
    assembler(customerAssembler)
    return customerAssembler.assembly()
}

