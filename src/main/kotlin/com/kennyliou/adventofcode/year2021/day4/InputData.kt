package com.kennyliou.adventofcode.year2021.day4

class InputData(private val moves: List<Int>, private val boards: List<Board>) {
    // go through moves and return the score of the winning board
    fun evaluateMoves(): Int {
        moves.forEach { move ->
            boards.forEach { board ->
                val score = board.markNumber(move)
                if (score > -1) {
                    return score
                }
            }
        }
        return -1
    }

    // go through moves and return the last board that wins
    fun evaluateLastWinningMoves(): Int {
        var lastWinningScore: Int
        val mutableBoardList = boards.toMutableList()
        var boardsToExam = mutableBoardList.toList()
        moves.forEach { move ->
            boardsToExam.forEach { board ->
                val score = board.markNumber(move)
                if (score > -1) {
                    lastWinningScore = score
                    if (mutableBoardList.size == 1) {
                        // we found the last one
                        return lastWinningScore
                    } else {
                        mutableBoardList.remove(board)
                    }
                }
            }
            boardsToExam = mutableBoardList.toList()
        }
        return -1
    }
}