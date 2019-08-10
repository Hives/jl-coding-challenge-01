private var remainingSeconds = 0

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    remainingSeconds = input

    val quantityDescriptions = units.sortedByDescending { it.numberOfSeconds }
        .map { UnitQuantity(it, getQuantityOfUnit(it)) }
        .filter { it.quantity != 0 }
        .map { makeHumanReadable(it) }

    return joinDescriptions(quantityDescriptions)
}

private data class Unit(val singularName: String, val pluralName: String, val numberOfSeconds: Int)
private data class UnitQuantity(val unit: Unit, val quantity: Int)

private val units = setOf(
    Unit("second", "seconds", 1),
    Unit("minute", "minutes", 60),
    Unit("hour",   "hours",   60 * 60),
    Unit("day",    "days",    60 * 60 * 24),
    Unit("year",   "years",   60 * 60 * 24 * 365)
)

private fun getQuantityOfUnit(unit: Unit): Int {
    val quantity = remainingSeconds / unit.numberOfSeconds
    remainingSeconds -= quantity * unit.numberOfSeconds
    return quantity
}

private fun makeHumanReadable(uq: UnitQuantity): String =
    "${uq.quantity} " + if (uq.quantity == 1) uq.unit.singularName else uq.unit.pluralName

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size >= 3) {
        val firstOnes = descriptions.subList(0, descriptions.size - 1).joinToString(", ")
        val lastOne = descriptions.last()
        listOf(firstOnes, lastOne)
    } else {
        descriptions
    }.joinToString(" and ")
