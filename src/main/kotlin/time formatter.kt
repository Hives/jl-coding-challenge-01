private var remainingSeconds = 0

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    remainingSeconds = input

    val quantityDescriptions = units.map {
        val quantity = getQuantityOfUnit(it)
        makeHumanReadable(quantity, it)
    }.filterNotNull()

    return joinDescriptions(quantityDescriptions)
}

private data class Unit(val singularName: String, val pluralName: String, val numberOfSeconds: Int)

private val units = listOf(
    Unit("year",   "years",   60 * 60 * 24 * 365),
    Unit("day",    "days",    60 * 60 * 24),
    Unit("hour",   "hours",   60 * 60),
    Unit("minute", "minutes", 60),
    Unit("second", "seconds", 1)
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
        "$quantity " + if (quantity == 1) unit.singularName else unit.pluralName
    }

private fun joinDescriptions(descriptions: List<String>): String =
    if (descriptions.size >= 3) {
        val firstOnes = descriptions.subList(0, descriptions.size - 1).joinToString(", ")
        val lastOne = descriptions.last()
        listOf(firstOnes, lastOne)
    } else {
        descriptions
    }.joinToString(" and ")
