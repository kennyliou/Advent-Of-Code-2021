package com.kennyliou.adventofcode.year2021.day10

import com.kennyliou.adventofcode.year2021.BaseTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SyntaxCheckerTest: BaseTest() {
    override fun getDayIndex(): Int {
        return 10
    }

    @Test
    fun testDay10Part1() {
        val expected = 26397
        assertEquals(expected, SyntaxChecker.getSyntaxErrorScore(getTestFilePath()))
    }

    @Test
    fun testDay10Part2() {
        val expected = 288957
        assertEquals(expected, SyntaxChecker.getAutoCompleteScore(getTestFilePath()))
    }
}