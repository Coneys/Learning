package patterns.creational.realBuilder

/*Describes how to create object. Director class hides steps, while builders hides implementation details*/

fun main() {

    val director = ComputerBuildingDirector()

    println("Building high end computer")
    val realComputerBuilder = RealComputerBuilder()
    director.makeHighEndPC(realComputerBuilder)
    println("Computer finished ${realComputerBuilder.getResult()}")

    println("Building high end computer manual")
    val computerManualBuilder = ComputerManualBuilder()
    director.makeHighEndPC(computerManualBuilder)
    println("Computer manual finished ${computerManualBuilder.getResult()}")


}