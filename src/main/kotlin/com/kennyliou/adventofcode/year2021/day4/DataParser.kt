package com.kennyliou.adventofcode.year2021.day4

import java.io.File

object DataParser {
    fun readData(fileName: String): InputData {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            val file = File(path.file)
            // read first line as move input
            val lines = file.readLines()
            val moves = getIntValuesFromString(lines[0], ",")
            val boards = mutableListOf<Board>()
            // starting from line 2, create board data
            var currentIndex = 2
            while (currentIndex < lines.size) {
                val board = createBoard(lines, currentIndex)
                boards.add(board)
                currentIndex += (board.height + 1)
            }
            return InputData(moves, boards)
        }
        return InputData(listOf(), listOf())
    }

    private fun getIntValuesFromString(input: String, divider: String): List<Int> {
        val moves = input.split(divider.toRegex())
        return moves.map {
            it.toInt()
        }.toList()
    }

    // construct board using inputList, given the starting index
    private fun createBoard(inputList: List<String>, startIndex: Int): Board {
        // assuming startIndex contains data
        val boardValue = mutableListOf<Array<Int>>()
        for (i in startIndex until inputList.size) {
            val data = inputList[i].trim()
            if (data.isEmpty()) {
                // we reach end of value
                break
            } else {
                boardValue.add(getIntValuesFromString(data, "\\s+").toTypedArray())
            }
        }
        return Board(boardValue.toTypedArray())
    }
}