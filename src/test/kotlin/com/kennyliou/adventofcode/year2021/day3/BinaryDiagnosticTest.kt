package com.kennyliou.adventofcode.year2021.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryDiagnosticTest {
    @Test
    fun testDay3Part1() {
        val expected = 198
        assertEquals(expected, BinaryDiagnostic("test/day3_test.txt").analyzeReport())
    }

    @Test
    fun testDay3Part2() {
        val expected = 230
        assertEquals(expected, BinaryDiagnostic("test/day3_test.txt").getLifeSupportRating())
    }
}