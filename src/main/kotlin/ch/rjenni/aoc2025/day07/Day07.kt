package ch.rjenni.aoc2025.day07

import ch.rjenni.aoc2025.utils.InputReader

class Day07 {
    fun solvePart1(input: List<String>): Long {
        if (input.isEmpty()) return 0
        
        val width = input[0].length
        val height = input.size
        
        // Find S in the first row
        val startCol = input[0].indexOf('S')
        if (startCol == -1) return 0
        
        var currentBeams = setOf(startCol)
        var splitCount = 0L
        
        // Simulate row by row starting from the first row
        for (r in 0 until height) {
            val nextBeams = mutableSetOf<Int>()
            
            for (col in currentBeams) {
                // If the beam has wandered out of bounds, it's gone
                if (col !in 0 until width) continue
                
                val cell = input[r][col]
                
                if (cell == '^') {
                    // Splitter
                    splitCount++
                    nextBeams.add(col - 1)
                    nextBeams.add(col + 1)
                } else {
                    // continues straight down
                    nextBeams.add(col)
                }
            }
            
            currentBeams = nextBeams
            if (currentBeams.isEmpty()) break
        }
        
        return splitCount
    }
    
    fun run() {
        val input = InputReader.readInput("07")
        println("Day 07 Part 1: ${solvePart1(input)}")
    }
}

fun main() {
    Day07().run()
}
