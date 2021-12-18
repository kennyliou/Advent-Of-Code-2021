package com.kennyliou.adventofcode.year2021

import com.kennyliou.adventofcode.year2021.util.Util

internal abstract class BaseTest {
    abstract fun getDayIndex(): Int

    fun getTestFilePath(): String {
        return Util.getTestFileName(getDayIndex())
    }
}