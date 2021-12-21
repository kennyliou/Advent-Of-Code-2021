package com.kennyliou.adventofcode.year2021.day8

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SevenSegmentDisplayDecoderTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 8
    }

    @Test
    fun testDay8Part1() {
        val expected = 26
        assertEquals(expected, SevenSegmentDisplayDecoder.countSimpleNumber(getTestFilePath()))
    }

    @Test
    fun testDay8Part2() {
        val expected = 61229
        assertEquals(expected, SevenSegmentDisplayDecoder.sumSevenSegmentDisplaysValue(getTestFilePath()))
    }
}