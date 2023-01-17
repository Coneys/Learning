package patterns.structural.flyweight

import patterns.structural.flyweight.structure.Item
import patterns.structural.flyweight.structure.ItemCategoryIcon
import patterns.structural.flyweight.utils.randomItemCategory


fun ItemCategoryIcon.Companion.forDefaultCategory() = ItemCategoryIcon(ByteArray(256))
fun ItemCategoryIcon.Companion.forPlaceCategory() = ItemCategoryIcon(ByteArray(256))
fun ItemCategoryIcon.Companion.forTripCategory() = ItemCategoryIcon(ByteArray(256))

fun main() {
    (0..999).map {
        val category = randomItemCategory()
        val icon = when (category) {
            1 -> ItemCategoryIcon.forPlaceCategory()
            2 -> ItemCategoryIcon.forTripCategory()
            else -> ItemCategoryIcon.forDefaultCategory()
        }
        Item(category, icon)
    }

    ItemCategoryIcon.printInstances()
}