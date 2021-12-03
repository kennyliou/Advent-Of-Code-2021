package com.kennyliou.adventofcode.year2021.util

import java.io.File

object FileReader {
    fun readFileLineByLine(fileName: String): List<Int> {
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
}