package patterns.structural.flyweight.structure

@JvmInline
value class ItemCategoryIcon(private val rawValue: ByteArray) {

    init {
        instances++
    }

    companion object {

        internal var instances: Long = 0

        fun printInstances() = println("Created $instances instances of ItemCategoryIcon")
    }
}
