package ch.rjenni.aoc2025.day02

import ch.rjenni.aoc2025.utils.InputReader

class Day02 {
    fun solve(input: String): Long {
        // Remove newlines just in case, though the problem says single line.
        val cleanedInput = input.replace("\n", "").replace("\r", "")
        val ranges = cleanedInput.split(",")
        var totalSum = 0L

        for (range in ranges) {
            if (range.isBlank()) continue
            val parts = range.split("-")
            val start = parts[0].toLong()
            val end = parts[1].toLong()

            for (i in start..end) {
                if (isInvalid(i)) {
                    totalSum += i
                }
            }
        }
        return totalSum
    }

    private fun isInvalid(number: Long): Boolean {
        val s = number.toString()
        if (s.length % 2 != 0) {
            return false
        }
        val mid = s.length / 2
        val firstHalf = s.take(mid)
        val secondHalf = s.substring(mid)
        return firstHalf == secondHalf
    }

    fun run() {
        val input = InputReader.readInputAsString("02").trim()
        println("Day 02 Result: ${solve(input)}")
    }
}

fun main() {
    Day02().run()
}
