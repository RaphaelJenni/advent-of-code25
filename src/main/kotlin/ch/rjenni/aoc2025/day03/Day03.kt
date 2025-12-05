package ch.rjenni.aoc2025.day03

import ch.rjenni.aoc2025.utils.InputReader

class Day03 {
    fun solvePart1(input: List<String>): Int {
        var totalOutputJoltage = 0

        for (batteryBankString in input) {
            if (batteryBankString.isBlank()) continue
            
            // Step 1: Find the first occurrence of the largest digit that is NOT at the last position.
            // This will be our tens digit.
            var tensDigit = -1
            var tensDigitIndex = -1
            
            for (i in 0 until batteryBankString.length - 1) {
                val digit = batteryBankString[i].digitToInt()
                if (digit > tensDigit) {
                    tensDigit = digit
                    tensDigitIndex = i
                    if (tensDigit == 9) break // Optimization: Can't get better than 9
                }
            }

            // Step 2: Find the largest digit in the remaining part of the string.
            // This will be our ones digit.
            var onesDigit = -1
            for (i in tensDigitIndex + 1 until batteryBankString.length) {
                val digit = batteryBankString[i].digitToInt()
                if (digit > onesDigit) {
                    onesDigit = digit
                    if (onesDigit == 9) break // Optimization: Can't get better than 9
                }
            }
            
            totalOutputJoltage += tensDigit * 10 + onesDigit
        }

        return totalOutputJoltage
    }

    fun solvePart2(input: List<String>): Long {
        var totalOutputJoltage = 0L

        for (batteryBankString in input) {
            if (batteryBankString.isBlank()) continue

            var currentBankJoltageString = ""
            var currentIndex = 0
            val digitsNeeded = 12
            
            for (count in 1..digitsNeeded) {
                val remainingNeeded = digitsNeeded - count
                // The range of valid indices for the next digit is [currentIndex, batteryBankString.length - 1 - remainingNeeded]
                // We subtract remainingNeeded because we must leave enough digits for the rest of the sequence.
                val searchEndIndex = batteryBankString.length - 1 - remainingNeeded
                
                var bestDigit = -1
                var bestDigitIndex = -1
                
                for (i in currentIndex..searchEndIndex) {
                    val digit = batteryBankString[i].digitToInt()
                    if (digit > bestDigit) {
                        bestDigit = digit
                        bestDigitIndex = i
                        if (bestDigit == 9) break // Optimization: Can't get better than 9
                    }
                }
                
                currentBankJoltageString += bestDigit
                currentIndex = bestDigitIndex + 1
            }
            totalOutputJoltage += currentBankJoltageString.toLong()
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
