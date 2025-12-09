package ch.rjenni.aoc2025.day06

import ch.rjenni.aoc2025.day05.Day05
import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day06Test : FunSpec({
    test("Day 06 Part 1 Example") {
        val input = listOf(
            "123 328  51 64 ",
            " 45 64  387 23 ",
            "  6 98  215 314",
            "*   +   *   +  "
        )
        val day06 = Day06()
        day06.solvePart1(input) shouldBe 4277556L
    }


    test("Day 06 Part 1 Real Input") {
        val input = InputReader.readInput("06")
        val day06 = Day06()
        val result = day06.solvePart1(input)

        println("Day 06 Part 1 Result: $result")
        result shouldBe 4449991244405L
    }

    test("Day 06 Part 2 Example") {
        val input = listOf(
            "123 328  51 64 ",
            " 45 64  387 23 ",
            "  6 98  215 314",
            "*   +   *   +  "
        )
        val day06 = Day06()
        day06.solvePart2(input) shouldBe 3263827L
    }

    test("Day 06 Part 2 Real Input") {
        val input = InputReader.readInput("06")
        val day06 = Day06()
        val result = day06.solvePart2(input)

        println("Day 06 Part 2 Result: $result")
        result shouldBe 9348430857627L
    }
})
