package com.kennyliou.adventofcode.year2021.day6

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LanternFishCalculatorTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 6
    }

    @Test
    fun testDay6Part1() {
        var expected = 26L
        assertEquals(expected, LanternFishCalculator.calculatorLanternFish(getTestFilePath(), 18))

        expected = 5934L
        assertEquals(expected, LanternFishCalculator.calculatorLanternFish(getTestFilePath(), 80))
    }

    @Test
    fun testDay6Part2() {
        val expected = 26984457539

        assertEquals(expected, LanternFishCalculator.calculatorLanternFish(getTestFilePath(), 256))
    }
}