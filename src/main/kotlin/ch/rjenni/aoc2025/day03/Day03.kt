package ch.rjenni.aoc2025.day03

import ch.rjenni.aoc2025.utils.InputReader

class Day03 {
    fun solvePart1(input: List<String>): Int {
        var totalOutputJoltage = 0

        for (batteryBankString in input) {
            if (batteryBankString.isBlank()) continue
            
            // Step 1: Find the first occurrence of the largest digit that is NOT at the last position.
            // This will be our tens digit.
            var digit1 = -1
            var digit1Index = -1
            
            for (i in 0 until batteryBankString.length - 1) {
                val digit = batteryBankString[i].digitToInt()
                if (digit > digit1) {
                    digit1 = digit
                    digit1Index = i
                    if (digit1 == 9) break // Optimization: Can't get better than 9
                }
            }

            // Step 2: Find the largest digit in the remaining part of the string.
            // This will be our ones digit.
            var digit2 = -1
            for (i in digit1Index + 1 until batteryBankString.length) {
                val digit = batteryBankString[i].digitToInt()
                if (digit > digit2) {
                    digit2 = digit
                    if (digit2 == 9) break // Optimization: Can't get better than 9
                }
            }
            
            totalOutputJoltage += digit1 * 10 + digit2
        }

        return totalOutputJoltage
    }

    fun run() {
        val input = InputReader.readInput("03")
        println("Day 03 Part 1: ${solvePart1(input)}")
    }
}

fun main() {
    Day03().run()
}
