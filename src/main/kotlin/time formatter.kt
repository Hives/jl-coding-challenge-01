import kotlin.math.max

fun formatTime(input: Int): String {
    if (input == 0) return "none"

    val seconds = input % 60
    val minutes = input / 60

    val secondsDescription = if (seconds == 1) "$seconds second" else "$seconds seconds"
    val minutesDescription = if (minutes == 1) "$minutes minute" else "$minutes minutes"

    if (minutes == 0) {
        return secondsDescription
    } else {
        if (seconds == 0) {
            return minutesDescription
        } else {
            return "$minutesDescription and $secondsDescription"
        }
    }
}
