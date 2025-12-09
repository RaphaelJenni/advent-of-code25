package ch.rjenni.aoc2025.day06

import ch.rjenni.aoc2025.utils.InputReader

class Day06 {

    fun solvePart1(input: List<String>): Long {
        // Parse input into separate problem blocks and sum their results
        return parseProblems(input).sumOf { problem ->
            // Part 1: Numbers are read horizontally (row by row) within the block
            val numbers = problem.lines.mapNotNull { line ->
                if (line.isBlank()) null else line.trim().toLong()
            }
            problem.calculate(numbers)
        }
    }

    fun solvePart2(input: List<String>): Long {
        // Parse input into separate problem blocks and sum their results
        return parseProblems(input).sumOf { problem ->
            // Part 2: Numbers are read vertically (column by column) within the block
            val width = problem.lines.first().length
            val numbers = (0 until width).mapNotNull { col ->
                // Construct the number string by reading top-to-bottom at this column index
                val numStr = problem.lines.map { line -> line[col] }
                    .joinToString("")
                    .replace(" ", "") // Remove spaces to form the digits
                
                if (numStr.isEmpty()) null else numStr.toLong()
            }
            problem.calculate(numbers)
        }
    }

    data class Problem(val lines: List<String>, val operator: String) {
        fun calculate(numbers: List<Long>): Long = when (operator) {
            "+" -> numbers.sum()
            "*" -> numbers.reduce { acc, n -> acc * n }
            else -> throw IllegalArgumentException("Unknown operator: $operator")
        }
    }

    /**
     * Splits the raw input into a list of Problems.
     * It identifies problems by finding full columns of spaces that act as separators.
     */
    private fun parseProblems(input: List<String>): List<Problem> {
        if (input.isEmpty()) return emptyList()

        val operatorRow = input.last()
        val numberRows = input.dropLast(1)
        val maxWidth = input.maxOf { it.length }

        val problems = mutableListOf<Problem>()
        var startCol = 0

        while (startCol < maxWidth) {
            // Find the end of the current problem block.
            // A block ends when we hit a column that is completely empty (or end of line).
            var endCol = startCol
            while (endCol < maxWidth && !isColumnEmpty(input, endCol)) {
                endCol++
            }

            // If we found a valid block (width > 0), extract it
            if (endCol > startCol) {
                val blockLines = numberRows.map { row ->
                    row.padEnd(maxWidth).substring(startCol, endCol)
                }
                val operator = operatorRow.padEnd(maxWidth).substring(startCol, endCol).trim()
                
                problems.add(Problem(blockLines, operator))
            }

            startCol = endCol + 1
        }
        return problems
    }

    private fun isColumnEmpty(allRows: List<String>, colIndex: Int): Boolean {
        return allRows.all { row ->
            // Use getOrElse to handle lines shorter than colIndex safely
            val char = row.getOrElse(colIndex) { ' ' }
            char == ' '
        }
    }

    fun run() {
        val input = InputReader.readInput("06")
        println("Day 06 Part 1: ${solvePart1(input)}")
        println("Day 06 Part 2: ${solvePart2(input)}")
    }
}

fun main() {
    Day06().run()
}
