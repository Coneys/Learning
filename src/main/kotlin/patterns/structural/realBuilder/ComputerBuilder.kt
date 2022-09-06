package patterns.structural.realBuilder

interface ComputerBuilder {
    fun setCPU(cpu: CPU)
    fun setGPU(gpu: GPU)
    fun setCoolingSystem(coolingSystem: CoolingSystem)
}

class RealComputerBuilder : ComputerBuilder {
    private lateinit var cpu: CPU
    private lateinit var gpu: GPU
    private lateinit var coolingSystem: CoolingSystem

    override fun setCPU(cpu: CPU) {
        this.cpu = cpu
    }

    override fun setGPU(gpu: GPU) {
        this.gpu = gpu
    }

    override fun setCoolingSystem(coolingSystem: CoolingSystem) {
        this.coolingSystem = coolingSystem
    }

    fun getResult() = Computer(cpu, gpu, coolingSystem)
}

class ComputerManualBuilder() : ComputerBuilder {
    private var cpuDescription: String = ""
    private var gpuDescription: String = ""
    private var coolingSystemDescription: String = ""

    override fun setCPU(cpu: CPU) {
        cpuDescription = when (cpu) {
            CPU.radeon4900 -> "Some description for radeon"
            CPU.i3 -> "Some description for i3"
            CPU.i7 -> "Some description for i7"
            CPU.i9 -> "Some description for i9"
        }
    }

    override fun setGPU(gpu: GPU) {
        gpuDescription = when (gpu) {
            GPU.GTX900 -> "Some description for gtx 900"
            GPU.GTX1080 -> "Some description for gtx 1080"
            GPU.RTX3090 -> "Some description for gtx 3090"
        }
    }

    override fun setCoolingSystem(coolingSystem: CoolingSystem) {
        coolingSystemDescription = when (coolingSystem) {
            CoolingSystem.WATER -> "Description for attaching water cooling "
            CoolingSystem.AIR -> "Description for attaching air cooling "
        }
    }

    fun getResult() = ComputerManual(cpuDescription, coolingSystemDescription, gpuDescription)
}
