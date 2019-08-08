private data class Unit(val name: String, val numberOfSeconds: Int)
private data class UnitQuantity(val quantity: Int, val description: String)
private var remainder = 0

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    remainder = input

    val quantityDescriptions = units.map { extractUnit(it) }
        .filter { it.quantity > 0 }
        .map { it.description }

    return joinDescriptions(quantityDescriptions)
}

private val units = listOf(
    Unit("year",   60 * 60 * 24 * 365),
    Unit("day",    60 * 60 * 24),
    Unit("hour",   60 * 60),
    Unit("minute", 60),
    Unit("second", 1)
)

private fun extractUnit(unit: Unit): UnitQuantity {
    val quantity = remainder / unit.numberOfSeconds
    val description = pluralise("$quantity ${unit.name}", quantity)
    remainder -= quantity * unit.numberOfSeconds
    return UnitQuantity(quantity, description)
}

private fun pluralise(string: String, number: Int) = if (number == 1) string else string + "s"

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size >= 3) {
        val firstOnes = descriptions.subList(0, descriptions.size - 1).joinToString(", ")
        val lastOne = descriptions.last()
        listOf(firstOnes, lastOne)
    } else {
        descriptions
    }.joinToString(" and ")
