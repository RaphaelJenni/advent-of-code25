package ch.rjenni.aoc2025.day04

import ch.rjenni.aoc2025.utils.InputReader

class Day04 {
    fun solvePart1(input: List<String>): Int {
        val grid = input.filter { it.isNotBlank() }.map { it.toCharArray() }
        val rows = grid.size
        if (rows == 0) return 0
        val cols = grid[0].size
        
        var accessibleCount = 0

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '@') {
                    val neighborCount = countNeighbors(grid, row, col, rows, cols)
                    if (neighborCount < 4) {
                        accessibleCount++
                    }
                }
            }
        }

        return accessibleCount
    }

    fun solvePart2(input: List<String>): Int {
        val grid = input.filter { it.isNotBlank() }.map { it.toCharArray() }
        val rows = grid.size
        if (rows == 0) return 0
        val cols = grid[0].size
        
        var totalRemoved = 0
        var changed = true

        while (changed) {
            changed = false
            val toRemove = mutableListOf<Pair<Int, Int>>()

            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    if (grid[row][col] == '@') {
                        val neighborCount = countNeighbors(grid, row, col, rows, cols)
                        if (neighborCount < 4) {
                            toRemove.add(row to col)
                        }
                    }
                }
            }

            if (toRemove.isNotEmpty()) {
                changed = true
                totalRemoved += toRemove.size
//                println("Removing ${toRemove.size} rolls")
                for ((r, c) in toRemove) {
                    grid[r][c] = '.' // Remove the roll
                }
            }
        }

        return totalRemoved
    }

    private fun countNeighbors(grid: List<CharArray>, row: Int, col: Int, rows: Int, cols: Int): Int {
        var count = 0
        // Check all 8 directions
        for (dRow in -1..1) {
            for (dCol in -1..1) {
                if (dRow == 0 && dCol == 0) continue // Skip the cell itself

                val newRow = row + dRow
                val newCol = col + dCol

                if (newRow in 0 until rows && newCol in 0 until cols) {
                    if (grid[newRow][newCol] == '@') {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun run() {
        val input = InputReader.readInput("04")
        println("Day 04 Part 1: ${solvePart1(input)}")
        println("Day 04 Part 2: ${solvePart2(input)}")
    }
}

fun main() {
    Day04().run()
}
