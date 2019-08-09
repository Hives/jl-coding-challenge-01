fun formatTime(input: Int): String {
    if (input == 0) return "none"

    remainingSeconds = input

    val quantityDescriptions = units.map {
        val quantity = getQuantityOfUnit(it)
        makeHumanReadable(quantity, it)
    }.filterNotNull()

    return joinDescriptions(quantityDescriptions)
}

private data class Name(val singular: String, val plural: String)
private data class Unit(val name: Name, val numberOfSeconds: Int)
private var remainingSeconds = 0

private val units = listOf(
    Unit(Name("year",   "years"),   60 * 60 * 24 * 365),
    Unit(Name("day",    "days"),    60 * 60 * 24),
    Unit(Name("hour",   "hours"),   60 * 60),
    Unit(Name("minute", "minutes"), 60),
    Unit(Name("second", "seconds"), 1)
)

private fun getQuantityOfUnit(unit: Unit): Int {
    val quantity = remainingSeconds / unit.numberOfSeconds
    remainingSeconds -= quantity * unit.numberOfSeconds
    return quantity
}

private fun makeHumanReadable(quantity: Int, unit: Unit): String? =
    if (quantity == 0) {
        null
    } else {
        "$quantity " + if (quantity == 1) unit.name.singular else unit.name.plural
    }

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size >= 3) {
        val firstOnes = descriptions.subList(0, descriptions.size - 1).joinToString(", ")
        val lastOne = descriptions.last()
        listOf(firstOnes, lastOne)
    } else {
        descriptions
    }.joinToString(" and ")
