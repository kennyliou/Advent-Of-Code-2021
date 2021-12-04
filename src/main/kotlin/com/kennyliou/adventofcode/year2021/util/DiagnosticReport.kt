package com.kennyliou.adventofcode.year2021.util

class DiagnosticReport(fileName: String) {

    val width: Int
    val size: Int
    val data: List<List<Int>>

    init {
        val lines = FileReader.readFileLineAsString(fileName)
        width = lines[0].length
        size = lines.size
        data = lines.map { line ->
            line.toCharArray().map { c: Char ->
                c.toString().toInt()
            }.toList()
        }.toList()
    }
}