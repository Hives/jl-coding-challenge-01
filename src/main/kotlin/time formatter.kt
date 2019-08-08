fun formatTime(input: Int): String {
    if (input == 0) return "none"

    val units:List<UnitQuantity> = listOf(
        formatMinutes(input),
        formatSeconds(input)
    )

    return joinUnits(units)
}

private data class UnitQuantity(val quantity: Int, val description: String)

private fun formatSeconds(input: Int): UnitQuantity {
    val name = "second"
    val quantity = input % 60
    val description = if (quantity == 1) "$quantity $name" else "$quantity ${name}s"
    return UnitQuantity(quantity, description)
}

private fun formatMinutes(input: Int): UnitQuantity {
    val name = "minute"
    val quantity = input / 60
    val description = if (quantity == 1) "$quantity $name" else "$quantity ${name}s"
    return UnitQuantity(quantity, description)
}

private fun joinUnits(units: List<UnitQuantity>): String =
    units.filter { it.quantity > 0 }.joinToString(" and ") { it.description }
