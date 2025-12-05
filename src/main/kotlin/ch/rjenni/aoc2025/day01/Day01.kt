package ch.rjenni.aoc2025.day01

import ch.rjenni.aoc2025.utils.InputReader

class Day01 {
    fun solve(input: List<String>): Int {
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

    fun run() {
        val input = InputReader.readInput("01")
        val result = solve(input)
        println("Day 01 Result: $result")
    }
}

fun main() {
    Day01().run()
}
