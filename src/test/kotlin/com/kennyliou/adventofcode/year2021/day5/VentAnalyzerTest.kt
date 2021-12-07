package com.kennyliou.adventofcode.year2021.day5

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VentAnalyzerTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 5
    }

    @Test
    fun testDay5Part1() {
        val expected = 5
        assertEquals(expected, VentAnalyzer.analyze(getTestFilePath(), 10, true))
    }

    @Test
    fun testDay5Part2() {
        val expected = 12
        assertEquals(expected, VentAnalyzer.analyze(getTestFilePath(), 10, false))
    }
}