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

    fun solvePart2(input: List<String>): Long {
        val ranges = mutableListOf<LongRange>()
        
        for (line in input) {
            if (line.isBlank()) {
                break // We only care about ranges for Part 2
            }
            val parts = line.split("-")
            val start = parts[0].toLong()
            val end = parts[1].toLong()
            ranges.add(start..end)
        }

        if (ranges.isEmpty()) return 0L

        // Sort ranges by start
        ranges.sortBy { it.first }

        var totalFresh = 0L
        // Initialize currentEnd before the start of the first range so it's treated as a new range
        var currentEnd = ranges[0].first - 1

        for (range in ranges) {
            val start = range.first
            val end = range.last

            if (start > currentEnd) {
                // Disjoint range (or contiguous but distinct)
                totalFresh += (end - start + 1)
                currentEnd = end
            } else if (end > currentEnd) {
                // Overlapping range, extend it
                totalFresh += (end - currentEnd)
                currentEnd = end
            }
            // Else: range is fully contained in the previous one, ignore
        }
        return totalFresh
    }

    fun run() {
        val input = InputReader.readInput("05")
        println("Day 05 Part 1: ${solvePart1(input)}")
        println("Day 05 Part 2: ${solvePart2(input)}")
    }
}

fun main() {
    Day05().run()
}
