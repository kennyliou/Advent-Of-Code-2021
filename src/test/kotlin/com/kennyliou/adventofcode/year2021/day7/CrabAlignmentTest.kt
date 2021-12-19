package com.kennyliou.adventofcode.year2021.day7

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CrabAlignmentTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 7
    }

    @Test
    fun testDay7Part1() {
        val expected = 2
        assertEquals(expected, CrabAlignment.findCheapestFuel(getTestFilePath()))
    }

    @Test
    fun testDay7Part2() {
        val expected = 168
        assertEquals(expected, CrabAlignment.findCheapestFuelFactorial(getTestFilePath()))
    }
}