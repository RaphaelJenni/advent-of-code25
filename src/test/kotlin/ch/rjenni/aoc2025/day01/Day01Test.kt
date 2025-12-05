package ch.rjenni.aoc2025.day01

import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day01Test : FunSpec({

    test("Day 01 Example") {
        val input = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
        )
        val day01 = Day01()
        val result = day01.solvePart1(input)
        result shouldBe 3
    }

    test("Day 01 Real Input") {
        val input = InputReader.readInput("01")
        val day01 = Day01()
        val result = day01.solvePart1(input)

        result shouldBe 1007
    }

    test("Day 01 Part 2 Example") {
        val input = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
        )
        val day01 = Day01()
        val result = day01.solvePart2(input)
        result shouldBe 6
    }

    test("Day 01 Part 2 Real Input") {
        val input = InputReader.readInput("01")
        val day01 = Day01()
        val result = day01.solvePart2(input)

        result shouldBe 5820
    }
})