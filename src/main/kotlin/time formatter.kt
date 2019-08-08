private data class Unit(val name: String, val numberOfSeconds: Int)
private data class UnitQuantity(val quantity: Int, val description: String)
private var seconds = 0

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    seconds = input

    val quantityDescriptions = units.map { extractUnit(it) }
        .filter { it.quantity > 0 }
        .map { it.description }

    return joinDescriptions(quantityDescriptions)
}

private val units = listOf(
    Unit("day", 60 * 60 * 24),
    Unit("hour", 60 * 60),
    Unit("minute", 60),
    Unit("second", 1)
)

private fun extractUnit(unit: Unit): UnitQuantity {
    val quantity = seconds / unit.numberOfSeconds
    val description = pluralise("$quantity ${unit.name}", quantity)
    seconds -= quantity * unit.numberOfSeconds
    return UnitQuantity(quantity, description)
}

private fun pluralise(string: String, number: Int) = if (number == 1) string else string + "s"

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size > 2) {
        val firstDescriptions = descriptions.subList(0, descriptions.size - 1).joinToString()
        val lastDescription = descriptions.last()
        listOf(firstDescriptions, lastDescription).joinToString(" and ")
    } else {
        descriptions.joinToString(" and ")
    }
