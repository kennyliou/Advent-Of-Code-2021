package com.kennyliou.adventofcode.year2021.util

class Command(val direction: Direction, val delta: Int) {
    enum class Direction {
        UNKNOWN,
        UP,
        DOWN,
        FORWARD,
    }

    companion object {
        fun fromString(command: String): Command {
            val commandPair = command.split(" ")
            if (commandPair.size < 2) {
                // invalid command
                return Command(Direction.UNKNOWN, -1)
            }
            return Command(Direction.valueOf(commandPair[0].uppercase()), commandPair[1].toInt())
        }
    }
}