package com.kennyliou.adventofcode.year2021.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SonarReportAnalyzerTest {
    private val analyzer = SonarReportAnalyzer()

    @Test
    fun testDay1Part1() {
        val expected = 7
        assertEquals(expected, analyzer.analyzeFile("test/day1_test.txt"))
    }

    @Test
    fun testDay1Part2() {
        val expected = 5
        assertEquals(expected, analyzer.analyzePart2("test/day1_test.txt"))
    }
}