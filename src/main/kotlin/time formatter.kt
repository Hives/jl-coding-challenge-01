private data class Unit(val name: String, val numberOfSeconds: Int)
private data class UnitQuantity(val quantity: Int, val description: String)
private var seconds = 0

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    seconds = input

    val unitQuantityDescriptions = units.map { extractUnit(it) }
        .filter { it.quantity > 0 }
        .map { it.description }

    return unitQuantityDescriptions.joinToString(" and ")
}

private val units = listOf(
    Unit("hour", 60 * 60),
    Unit("minute", 60),
    Unit("second", 1)
)

private fun extractUnit(unit: Unit): UnitQuantity {
    val quantity = seconds / unit.numberOfSeconds
    val description = "$quantity " + pluralise(unit.name, quantity)
    seconds -= quantity * unit.numberOfSeconds
    return UnitQuantity(quantity, description)
}

private fun pluralise(string: String, number: Int) = if (number == 1) string else string + "s"
