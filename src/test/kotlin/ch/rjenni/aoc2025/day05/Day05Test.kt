package ch.rjenni.aoc2025.day05

import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day05Test : FunSpec({
    test("Day 05 Part 1 Example") {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32"
        )
        val day05 = Day05()
        day05.solvePart1(input) shouldBe 3
    }

    test("Day 05 Part 1 Real Input") {
        val input = InputReader.readInput("05")
        val day05 = Day05()
        val result = day05.solvePart1(input)
        
        println("Day 05 Part 1 Result: $result")
        result shouldBe 789
    }

    test("Day 05 Part 2 Example") {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32"
        )
        val day05 = Day05()
        day05.solvePart2(input) shouldBe 14
    }

    test("Day 05 Part 2 Real Input") {
        val input = InputReader.readInput("05")
        val day05 = Day05()
        val result = day05.solvePart2(input)

        println("Day 05 Part 2 Result: $result")
        result shouldBe 343329651880509L
    }
})
