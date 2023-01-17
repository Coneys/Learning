package patterns.structural.flyweight

import patterns.structural.flyweight.structure.Item
import patterns.structural.flyweight.structure.ItemCategoryIcon
import patterns.structural.flyweight.utils.randomItemCategory


private val defaultCategoryIcon by lazy { ItemCategoryIcon.forDefaultCategory() }
private val placeCategoryIcon by lazy { ItemCategoryIcon.forPlaceCategory() }
private val tripCategoryIcon by lazy { ItemCategoryIcon.forTripCategory() }

fun ItemCategoryIcon.Companion.forId(categoryId: Int): ItemCategoryIcon {
    val placeCategoryId = 1
    val tripCategoryId = 2
    return when (categoryId) {
        placeCategoryId -> placeCategoryIcon
        tripCategoryId -> tripCategoryIcon
        else -> defaultCategoryIcon
    }
}

fun main() {
    (0..999).map {
        val category = randomItemCategory()
        val icon = ItemCategoryIcon.forId(category)
        Item(category, icon)
    }

    ItemCategoryIcon.printInstances()
}