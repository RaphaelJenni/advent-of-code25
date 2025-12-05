package ch.rjenni.aoc2025.day05

import ch.rjenni.aoc2025.utils.InputReader

class Day05 {
    fun solvePart1(input: List<String>): Int {
        val ranges = mutableListOf<LongRange>()
        val ids = mutableListOf<Long>()
        var parsingRanges = true

        // parsing input
        for (line in input) {
            if (line.isBlank()) {
                parsingRanges = false
                continue
            }

            if (parsingRanges) {
                val parts = line.split("-")
                val start = parts[0].toLong()
                val end = parts[1].toLong()
                ranges.add(start..end)
            } else {
                ids.add(line.toLong())
            }
        }


        var freshCount = 0
        for (id in ids) {
            for (range in ranges) {
                if (id in range) {
                    freshCount++
                    break // Found a range, it's fresh
                }
            }
        }
        return freshCount
    }

    fun run() {
        val input = InputReader.readInput("05")
        println("Day 05 Part 1: ${solvePart1(input)}")
    }
}

fun main() {
    Day05().run()
}
