package com.kennyliou.adventofcode.year2021.day5

import java.lang.Integer.max
import java.lang.Math.abs
import kotlin.math.min

class HydrothermalVentData(private val from: Pair<Int, Int>, private val to: Pair<Int, Int>) {

    fun plotData(data: Array<Array<Int>>, straightOnly: Boolean) {
        if (straightOnly) {
            if ((from.first == to.first && from.second == to.second) ||
                (from.first != to.first && from.second != to.second)
            ) {
                return
            }
        } else if ((from.first == to.first && from.second == to.second)) {
            return
        }

        if (from.first != to.first && from.second != to.second) {
            // check if diagonal
            if (abs(from.first - to.first) == abs(from.second - to.second)) {
                // is diagonal
                val xDirection = if (from.first > to.first) -1 else 1
                val yDirection = if (from.second > to.second) -1 else 1
                var step = abs(from.first - to.first)
                var x = from.first
                var y = from.second
                while(step > -1) {
                    data[x][y] += 1
                    step -= 1
                    x += xDirection
                    y += yDirection
                }
            }
        } else {
            val rowS = min(from.first, to.first)
            val rowE = max(from.first, to.first)
            val colS = min(from.second, to.second)
            val colE = max(from.second, to.second)
            for (i in rowS..rowE) {
                for (j in colS..colE) {
                    data[i][j] += 1
                }
            }
        }
    }

    companion object {
        fun createHydrothermalVentData(rawData: String): HydrothermalVentData {
            val match = Regex("(\\d+)").findAll(rawData)
            val result = match.map { it.value.toInt() }.toList()
            return HydrothermalVentData(
                Pair(result[0], result[1]),
                Pair(result[2], result[3])
            )
        }
    }
}