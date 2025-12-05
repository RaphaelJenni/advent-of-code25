package ch.rjenni.aoc2025.utils

import java.io.File
import java.net.URL

class InputReader {
    companion object {
        fun readInput(day: String): List<String> {
            val fileName = "day$day.txt"
            val resource: URL = InputReader::class.java.classLoader.getResource(fileName)
                ?: throw IllegalArgumentException("File not found: $fileName")
            return File(resource.toURI()).readLines()
        }

        fun readInputAsString(day: String): String {
            val fileName = "day$day.txt"
            val resource: URL = InputReader::class.java.classLoader.getResource(fileName)
                ?: throw IllegalArgumentException("File not found: $fileName")
            return File(resource.toURI()).readText()
        }
    }
}
