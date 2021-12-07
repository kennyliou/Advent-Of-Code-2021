package com.kennyliou.adventofcode.year2021.day2

import com.kennyliou.adventofcode.year2021.BaseTest
import com.kennyliou.adventofcode.year2021.util.FileReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SubmarineControlTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 2
    }

    @Test
    fun testDay2Part1() {
        val expected = 150
        assertEquals(expected, SubmarineControl.analyzeCommands(FileReader.getCommandsFromFile(getTestFilePath())))
    }

    @Test
    fun testDay2Part2() {
        val expected = 900
        assertEquals(expected, SubmarineControl.analyzeAim(FileReader.getCommandsFromFile(getTestFilePath())))
    }
}