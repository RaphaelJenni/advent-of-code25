package ch.rjenni.aoc2025.day01

import ch.rjenni.aoc2025.utils.InputReader

class Day01 {
    fun solvePart1(input: List<String>): Int {
        var currentPosition = 50
        var zeroCount = 0

        for (instruction in input) {
            val direction = instruction[0]
            val amount = instruction.substring(1).toInt()

            if (direction == 'L') {
                currentPosition = (currentPosition - amount) % 100
                if (currentPosition < 0) {
                    currentPosition += 100
                }
            } else if (direction == 'R') {
                currentPosition = (currentPosition + amount) % 100
            }

            if (currentPosition == 0) {
                zeroCount++
            }
        }

        return zeroCount
    }

    fun solvePart2(input: List<String>): Long {
        var currentPosition = 50
        var totalZeroHits = 0L

        for (instruction in input) {
            val direction = instruction[0]
            val amount = instruction.substring(1).toInt()

            if (direction == 'R') {
                val hits = (currentPosition + amount) / 100
                totalZeroHits += hits
                currentPosition = (currentPosition + amount) % 100
            } else if (direction == 'L') {
                val end = currentPosition - 1
                val startMinus1 = currentPosition - amount - 1
                val hits = Math.floorDiv(end, 100) - Math.floorDiv(startMinus1, 100)
                totalZeroHits += hits

                currentPosition = (currentPosition - amount) % 100
                if (currentPosition < 0) {
                    currentPosition += 100
                }
            }
        }
        return totalZeroHits
    }

    fun run() {
        val input = InputReader.readInput("01")
        println("Day 01 Part 1: ${solvePart1(input)}")
        println("Day 01 Part 2: ${solvePart2(input)}")
    }
}

fun main() {
    Day01().run()
}
