package ch.rjenni.aoc2025.day04

import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day04Test : FunSpec({
    test("Day 04 Part 1 Example") {
        val input = listOf(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
        )
        val day04 = Day04()
        day04.solvePart1(input) shouldBe 13
    }

    test("Day 04 Part 1 Real Input") {
        val input = InputReader.readInput("04")
        val day04 = Day04()
        val result = day04.solvePart1(input)
        
        println("Day 04 Part 1 Result: $result")
        result shouldBe 1578
    }

    test("Day 04 Part 2 Example") {
        val input = listOf(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
        )
        val day04 = Day04()
        day04.solvePart2(input) shouldBe 43
    }

    test("Day 04 Part 2 Real Input") {
        val input = InputReader.readInput("04")
        val day04 = Day04()
        val result = day04.solvePart2(input)

        println("Day 04 Part 2 Result: $result")
        result shouldBe 10132
    }
})
