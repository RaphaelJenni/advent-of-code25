package ch.rjenni.aoc2025.day02

import ch.rjenni.aoc2025.utils.InputReader

class Day02 {
    fun solvePart1(input: String): Long {
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
                if (isInvalidPart1(i)) {
                    totalSum += i
                }
            }
        }
        return totalSum
    }

    fun solvePart2(input: String): Long {
        val cleanedInput = input.replace("\n", "").replace("\r", "")
        val ranges = cleanedInput.split(",")
        var totalSum = 0L

        for (range in ranges) {
            if (range.isBlank()) continue
            val parts = range.split("-")
            val start = parts[0].toLong()
            val end = parts[1].toLong()

            for (i in start..end) {
                if (isInvalidPart2(i)) {
                    totalSum += i
                }
            }
        }
        return totalSum
    }

    private fun isInvalidPart1(number: Long): Boolean {
        val s = number.toString()
        if (s.length % 2 != 0) {
            return false
        }
        val mid = s.length / 2
        val firstHalf = s.substring(0, mid)
        val secondHalf = s.substring(mid)
        return firstHalf == secondHalf
    }

    private fun isInvalidPart2(number: Long): Boolean {
        val sequence = number.toString()
        val len = sequence.length
        if (len < 2) return false // Cannot repeat at least twice if length is 1

        // Try all possible lengths for the repeating sequence
        for (subSeqLen in 1..len / 2) {
            // The sub sequence length must be a divisor of len
            if (len % subSeqLen == 0) {
                val pattern = sequence.take(subSeqLen)
                val numberOfRepetitions = len / subSeqLen
                val constructedSequence = pattern.repeat(numberOfRepetitions)
                if (constructedSequence == sequence) {
                    return true
                }
            }
        }
        return false
    }

    fun run() {
        val input = InputReader.readInputAsString("02").trim()
        println("Day 02 Part 1: ${solvePart1(input)}")
        println("Day 02 Part 2: ${solvePart2(input)}")
    }
}

fun main() {
    Day02().run()
}
