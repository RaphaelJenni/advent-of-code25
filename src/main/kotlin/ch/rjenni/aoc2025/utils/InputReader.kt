package ch.rjenni.aoc2025.utils

import java.io.BufferedReader
import java.io.InputStreamReader

class InputReader {
    companion object {
        fun readInput(day: String): List<String> {
            val fileName = "day$day.txt"
            val stream = InputReader::class.java.classLoader.getResourceAsStream(fileName)
                ?: throw IllegalArgumentException("File not found: $fileName")
            return BufferedReader(InputStreamReader(stream)).readLines()
        }

        fun readInputAsString(day: String): String {
            val fileName = "day$day.txt"
            val stream = InputReader::class.java.classLoader.getResourceAsStream(fileName)
                ?: throw IllegalArgumentException("File not found: $fileName")
            return BufferedReader(InputStreamReader(stream)).readText()
        }
    }
}
