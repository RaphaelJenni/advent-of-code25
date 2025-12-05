package ch.rjenni.aoc2025.day02

import ch.rjenni.aoc2025.day01.Day01
import ch.rjenni.aoc2025.utils.InputReader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day02Test : FunSpec({
    test("Day 02 Part 1 Example") {
        val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
        val day02 = Day02()
        day02.solvePart1(input) shouldBe 1227775554L
    }

    test("Day 02 Part 2 Example") {
        val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
        val day02 = Day02()
        day02.solvePart2(input) shouldBe 4174379265L
    }

    test("Day 02 Part 1 Real Input") {
        val input = InputReader.readInputAsString("02").trim()
        val day02 = Day02()
        val result = day02.solvePart1(input)
        
        result shouldBe 19219508902L
    }

    test("Day 02 Part 2 Real Input") {
        val input = InputReader.readInputAsString("02").trim()
        val day02 = Day02()
        val result = day02.solvePart2(input)

        result shouldBe 27180728081L
    }
})
