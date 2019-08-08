private data class Name(val singular: String, val plural: String)
private data class Unit(val name: Name, val numberOfSeconds: Int)
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
    Unit(Name("year",   "years"),   60 * 60 * 24 * 365),
    Unit(Name("day",    "days"),    60 * 60 * 24),
    Unit(Name("hour",   "hours"),   60 * 60),
    Unit(Name("minute", "minutes"), 60),
    Unit(Name("second", "seconds"), 1)
)

private fun extractUnit(unit: Unit): UnitQuantity {
    val quantity = remainder / unit.numberOfSeconds
    val description = "$quantity " + if (quantity == 1) unit.name.singular else unit.name.plural
    remainder -= quantity * unit.numberOfSeconds
    return UnitQuantity(quantity, description)
}

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size >= 3) {
        val firstOnes = descriptions.subList(0, descriptions.size - 1).joinToString(", ")
        val lastOne = descriptions.last()
        listOf(firstOnes, lastOne)
    } else {
        descriptions
    }.joinToString(" and ")
