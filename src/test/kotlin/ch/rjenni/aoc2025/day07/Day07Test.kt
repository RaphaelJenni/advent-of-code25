package ch.rjenni.aoc2025.day07

import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day07Test : FunSpec({
    test("Day 07 Part 1 Example") {
        val input = listOf(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "..............."
        )
        Day07().solvePart1(input) shouldBe 21
    }

    test("Day 07 Part 1 Real Input") {
        val input = InputReader.readInput("07")
        val result = Day07().solvePart1(input)

        println("Day 07 Part 1 Result: $result")
         result shouldBe 1703
    }
})
