package com.kennyliou.adventofcode.year2021.day1

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SonarReportAnalyzerTest: BaseTest() {
    private val analyzer = SonarReportAnalyzer()

    override fun getDayIndex(): Int {
        return 1
    }

    @Test
    fun testDay1Part1() {
        val expected = 7
        assertEquals(expected, analyzer.analyzeFile(getTestFilePath()))
    }

    @Test
    fun testDay1Part2() {
        val expected = 5
        assertEquals(expected, analyzer.analyzePart2(getTestFilePath()))
    }
}