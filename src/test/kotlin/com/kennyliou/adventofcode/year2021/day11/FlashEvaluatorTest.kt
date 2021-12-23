package com.kennyliou.adventofcode.year2021.day11

import com.kennyliou.adventofcode.year2021.BaseTest
import com.kennyliou.adventofcode.year2021.com.kennyliou.adventofcode.year2021.day11.FlashEvaluator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FlashEvaluatorTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 11
    }

    @Test
    fun testDay11Part1() {
        var expected = 204
        assertEquals(expected, FlashEvaluator.evaluateFlash(getTestFilePath(), 10))

        expected = 1656
        assertEquals(expected, FlashEvaluator.evaluateFlash(getTestFilePath(), 100))
    }

    @Test
    fun testDay11Part2() {
        val expected = 195
        assertEquals(expected, FlashEvaluator.findAllFlashMoment(getTestFilePath()))
    }
}