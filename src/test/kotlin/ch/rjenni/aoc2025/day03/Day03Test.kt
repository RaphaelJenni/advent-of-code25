package ch.rjenni.aoc2025.day03

import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day03Test : FunSpec({
    test("Day 03 Part 1 Example") {
        val input = listOf(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111"
        )
        val day03 = Day03()
        day03.solvePart1(input) shouldBe 357
    }

    test("Day 03 Part 1 Real Input") {
        val input = InputReader.readInput("03")
        val day03 = Day03()
        val result = day03.solvePart1(input)
        
        println("Day 03 Part 1 Result: $result")
        result shouldBe 17244
    }
})
