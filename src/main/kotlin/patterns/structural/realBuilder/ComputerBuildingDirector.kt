package patterns.structural.realBuilder

class ComputerBuildingDirector {
    fun makeHighEndPC(builder: ComputerBuilder) {
        builder.setCPU(CPU.i9)
        builder.setGPU(GPU.RTX3090)
        builder.setCoolingSystem(CoolingSystem.WATER)
    }

    fun makeLowEndPC(builder: ComputerBuilder) {
        builder.setCPU(CPU.i3)
        builder.setGPU(GPU.GTX900)
        builder.setCoolingSystem(CoolingSystem.AIR)
    }
}
