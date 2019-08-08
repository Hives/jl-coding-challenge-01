fun formatTime(input: Int): String {
    if (input == 0) return "none"
    if (input == 1) return "1 second"
    return "$input seconds"
}

