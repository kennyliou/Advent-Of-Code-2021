package com.kennyliou.adventofcode.year2021.day3

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryDiagnosticTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 3
    }

    @Test
    fun testDay3Part1() {
        val expected = 198
        assertEquals(expected, BinaryDiagnostic(getTestFilePath()).analyzeReport())
    }

    @Test
    fun testDay3Part2() {
        val expected = 230
        assertEquals(expected, BinaryDiagnostic(getTestFilePath()).getLifeSupportRating())
    }
}