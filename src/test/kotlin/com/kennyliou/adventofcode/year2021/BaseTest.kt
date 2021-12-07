package com.kennyliou.adventofcode.year2021

internal abstract class BaseTest {
    abstract fun getDayIndex(): Int

    fun getTestFilePath(): String {
        return "test/day${getDayIndex()}_test.txt"
    }
}