package com.kennyliou.adventofcode.year2021.day4

class Board(private val board: Array<Array<Int>>) {
    private val marked = Array(board.size) { Array(board[0].size) {false} }
    private val width = board[0].size
    val height = board.size
    private var sum = board.sumOf { column ->
        column.sum()
    }

    // mark the number and return score, -1 if the board has not won yet.
    fun markNumber(number: Int): Int {
        var targetRow = -1
        var targetColumn = -1
        for (i in 0 until width) {
            for (j in 0 until height) {
                if (board[i][j] == number) {
                    marked[i][j] = true
                    sum -= number
                    targetRow = i
                    targetColumn = j
                }
            }
        }
        if (targetRow > -1 && targetColumn > -1) {
            // go through row and column current input belongs to and evaluate the board winning state
            if (hasWonRow(targetRow) || hasWonColumn(targetColumn)) {
                return number * sum
            }
        }
        return -1
    }

    private fun hasWonRow(row: Int): Boolean {
        for (i in 0 until height) {
            if (!marked[row][i]) {
                return false
            }
        }
        return true
    }

    private fun hasWonColumn(column: Int): Boolean {
        for (i in 0 until width) {
            if (!marked[i][column]) {
                return false
            }
        }
        return true
    }
}