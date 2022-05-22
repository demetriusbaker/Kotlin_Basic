package kuy_4

object TimeFormatter {
    fun formatDuration(seconds: Int): String {
        val second = seconds % 60
        var minute = seconds / 60
        var hour = minute / 60
        minute %= 60
        var day = hour / 24
        hour %= 24
        val year = day / 365
        day %= 365
        val timeText = arrayOf(year to "year", day to "day", hour to "hour",
            minute to "minute", second to "second"
        )
        val result = arrayListOf<String>()

        timeText.forEach { (time, text) ->
            if (time != 0) result.add("$time $text${if (time > 1) "s" else ""}") }
        if (result.size > 1){
            result[result.size - 2] += " and ${result[result.size - 1]}"
            result.remove(result[result.size - 1])
        }

        return if (result.isNotEmpty()) result.joinToString(separator = ", ") else "now"
    }
}