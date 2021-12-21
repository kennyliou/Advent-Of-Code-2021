package com.kennyliou.adventofcode.year2021.util

import com.kennyliou.adventofcode.year2021.day8.SevenSegmentDisplay
import java.io.File

object FileReader {
    fun readFileLineAsString(fileName: String): List<String> {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            return File(path.file).useLines { it.toList() }
        }
        return listOf()
    }

    fun readFileLineAsInt(fileName: String): List<Int> {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            return File(path.file).useLines {
                it.map { value ->
                    value.toInt()
                }.toList()
            }
        }
        return listOf()
    }

    fun readFileLineAsInts(fileName: String): List<Int> {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            return File(path.file).useLines {
                val firstLine = it.firstOrNull()
                val values = firstLine?.split(",")
                values?.map { value ->
                    value.toInt()
                }?.toList() ?: listOf()
            }
        }
        return listOf()
    }

    fun readFileAsSevenSegmentDisplayData(fileName: String): List<SevenSegmentDisplay> {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            return File(path.file).useLines {
                it.map { line ->
                    val data = line.split("|")
                    val hints = data[0].trim().split(" ")
                    val displays = data[1].trim().split(" ")
                    SevenSegmentDisplay(hints, displays)
                }.toList()
            }
        }
        return listOf()
    }

    fun getCommandsFromFile(fileName: String): List<Command> {
        val path = this::class.java.classLoader.getResource(fileName)
        if (path != null) {
            return File(path.file).useLines {
                it.map { value ->
                    Command.fromString(value)
                }.toList()
            }
        }
        return listOf()
    }
}