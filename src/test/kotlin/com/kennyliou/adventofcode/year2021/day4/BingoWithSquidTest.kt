package com.kennyliou.adventofcode.year2021.day4

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BingoWithSquidTest: BaseTest() {

    override fun getDayIndex(): Int {
        return 4
    }

    @Test
    fun testDay4Part1() {
        val expected = 4512
        assertEquals(expected, BingoWithSquid.play(getTestFilePath()))
    }

    @Test
    fun testDay4Part2() {
        val expected = 1924
        assertEquals(expected, BingoWithSquid.playFindLast(getTestFilePath()))
    }
}