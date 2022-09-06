package patterns.creational.realBuilder

enum class CPU {
    radeon4900, i3, i7, i9
}

enum class GPU {
    GTX900, GTX1080, RTX3090
}

enum class CoolingSystem {
    WATER, AIR
}

class Computer(val cpu: CPU, val gpu: GPU, val coolingSystem: CoolingSystem) {
    override fun toString(): String {
        return "Computer with $cpu $gpu and $coolingSystem"
    }
}

class ComputerManual(
    val cpuDescription: String,
    val coolingSystemAttachmentDescription: String,
    val mostFrequentGpuIssuesDescription: String
) {
    override fun toString(): String {
        return "Computer with $cpuDescription $mostFrequentGpuIssuesDescription and $coolingSystemAttachmentDescription"
    }
}

