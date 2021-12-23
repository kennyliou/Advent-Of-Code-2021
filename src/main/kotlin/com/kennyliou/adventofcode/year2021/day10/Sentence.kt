package com.kennyliou.adventofcode.year2021.day10

class Sentence(val input: String) {
    val status: Status
    val errorScore: Int
    val autoCompleteScore: Long
    init {
        val stack = ArrayDeque<Char>()
        var inputStatus: Status = Status.CORRECT
        var score = 0
        for (i in input.indices) {
            val c = input[i]
            if (isOpen(c)) {
                stack.addFirst(c)
            } else {
                val open = stack.removeFirst()
                if (!isLegalChunk(open, c)) {
                    inputStatus = Status.CORRUPTED
                    score = getErrorScore(c)
                    break
                }
            }
        }
        if (inputStatus != Status.CORRUPTED && stack.isNotEmpty()) {
            inputStatus = Status.INCOMPLETE
            autoCompleteScore = getAutoCompleteScore(stack)
        } else {
            autoCompleteScore = 0
        }
        status = inputStatus
        errorScore = score
    }

    enum class Status {
        CORRECT,
        INCOMPLETE,
        CORRUPTED,
    }

    companion object {
        private fun isOpen(c: Char): Boolean {
            return '(' == c || '[' == c || '{' == c || '<' == c
        }

        private fun isLegalChunk(open: Char, close: Char): Boolean {
            return getCloseChar(open) == close
        }

        private fun getCloseChar(open: Char): Char {
            return when(open) {
                '(' -> ')'
                '[' -> ']'
                '{' -> '}'
                '<' -> '>'
                else -> '0'
            }
        }

        private fun getErrorScore(c: Char): Int {
            return when(c) {
                ')' -> 3
                ']' -> 57
                '}' -> 1197
                '>' -> 25137
                else -> 0
            }
        }

        private fun getAutoCompleteScore(c: Char): Int {
            return when(c) {
                ')' -> 1
                ']' -> 2
                '}' -> 3
                '>' -> 4
                else -> 0
            }
        }

        private fun getAutoCompleteScore(stack: ArrayDeque<Char>): Long {
            var score = 0L
            for (i in stack.indices) {
                score = score * 5 + getAutoCompleteScore(getCloseChar(stack[i]))
            }

            return score
        }
    }
}