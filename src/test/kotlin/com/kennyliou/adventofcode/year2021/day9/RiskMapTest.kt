package com.kennyliou.adventofcode.year2021.day9

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RiskMapTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 9
    }

    @Test
    fun testDay9Part1() {
        val expected = 15
        assertEquals(expected, RiskMap.getRiskLevel(getTestFilePath()))
    }

    @Test
    fun testDay9Part2() {
        val expected = 1134
        assertEquals(expected, RiskMap.getBasinArea(getTestFilePath()))
    }
}