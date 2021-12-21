/**
 * --- Day 9: Smoke Basin ---
 * These caves seem to be lava tubes. Parts are even still volcanically active; small hydrothermal vents release smoke into the caves that slowly settles like rain.
 *
 * If you can model how the smoke flows through the caves, you might be able to avoid it and be that much safer. The submarine generates a heightmap of the floor of the nearby caves for you (your puzzle input).
 *
 * Smoke flows to the lowest point of the area it's in. For example, consider the following heightmap:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * Each number corresponds to the height of a particular location, where 9 is the highest and 0 is the lowest a location can be.
 *
 * Your first goal is to find the low points - the locations that are lower than any of its adjacent locations. Most locations have four adjacent locations (up, down, left, and right); locations on the edge or corner of the map have three or two adjacent locations, respectively. (Diagonal locations do not count as adjacent.)
 *
 * In the above example, there are four low points, all highlighted: two are in the first row (a 1 and a 0), one is in the third row (a 5), and one is in the bottom row (also a 5). All other locations on the heightmap have some lower adjacent location, and so are not low points.
 *
 * The risk level of a low point is 1 plus its height. In the above example, the risk levels of the low points are 2, 1, 6, and 6. The sum of the risk levels of all low points in the heightmap is therefore 15.
 *
 * Find all of the low points on your heightmap. What is the sum of the risk levels of all low points on your heightmap?
 *
 * --- Part Two ---
 * Next, you need to find the largest basins so you know what areas are most important to avoid.
 *
 * A basin is all locations that eventually flow downward to a single low point. Therefore, every low point has a basin, although some basins are very small. Locations of height 9 do not count as being in any basin, and all other locations will always be part of exactly one basin.
 *
 * The size of a basin is the number of locations within the basin, including the low point. The example above has four basins.
 *
 * The top-left basin, size 3:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The top-right basin, size 9:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The middle basin, size 14:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * The bottom-right basin, size 9:
 *
 * 2199943210
 * 3987894921
 * 9856789892
 * 8767896789
 * 9899965678
 * Find the three largest basins and multiply their sizes together. In the above example, this is 9 * 14 * 9 = 1134.
 *
 * What do you get if you multiply together the sizes of the three largest basins?
 */
package com.kennyliou.adventofcode.year2021.day9

import com.kennyliou.adventofcode.year2021.util.FileReader

class RiskMap(private val data: List<List<Int>>) {
    private val width: Int = data[0].size
    private val height: Int = data.size

    fun getRiskLevel(): Int {
        var riskLevelSum = 0
        for (y in 0 until height) {
            for (x in 0 until width) {
                val riskLevel = getRiskLevelAtPosition(x, y)
                if (riskLevel > -1) {
                    riskLevelSum += riskLevel
                }
            }
        }

        return riskLevelSum
    }

    fun findBasinArea(): Int {
        val risks = mutableListOf<Pair<Int, Int>>()
        val areas = mutableListOf<Int>()

        for (y in 0 until height) {
            for (x in 0 until width) {
                val riskLevel = getRiskLevelAtPosition(x, y)
                if (riskLevel > -1) {
                    risks.add(Pair(x, y))
                }
            }
        }

        risks.map {
            areas.add(findBasinFromPosition(it))
        }

        areas.sortDescending()

        return areas[0] * areas[1] * areas[2]
    }

    private fun findBasinFromPosition(position: Pair<Int, Int>): Int {
        val validNeighbors = mutableListOf<Pair<Int, Int>>()
        validNeighbors.add(position)
        addValidNeighbor(position, validNeighbors)

        return validNeighbors.size
    }

    private fun addValidNeighbor(position: Pair<Int, Int>, list: MutableList<Pair<Int, Int>>) {
        val xNeighbors = mutableListOf<Int>()
        val yNeighbors = mutableListOf<Int>()
        if (position.first > 0) {
            xNeighbors.add(position.first - 1)
        }
        if (position.first < width - 1) {
            xNeighbors.add(position.first + 1)
        }
        if (position.second > 0) {
            yNeighbors.add(position.second - 1)
        }
        if (position.second < height - 1) {
            yNeighbors.add(position.second + 1)
        }

        xNeighbors.map { x ->
            val pair = Pair(x, position.second)
            if (data[position.second][x] != 9 && !list.contains(pair)) {
                list.add(pair)
                addValidNeighbor(pair, list)
            }
        }
        yNeighbors.map { y ->
            val pair = Pair(position.first, y)
            if (data[y][position.first] != 9 && !list.contains(pair)) {
                list.add(pair)
                addValidNeighbor(pair, list)
            }
        }
    }

    // -1 means this position is not lowest point, risk level otherwise.
    private fun getRiskLevelAtPosition(x: Int, y: Int): Int {
        val currentValue = data[y][x]

        if (x != 0 && data[y][x-1] <= currentValue) {
            return -1
        }
        if (x != width -1 && data[y][x+1] <= currentValue) {
            return -1
        }
        if (y != 0 && data[y-1][x] <= currentValue) {
            return -1
        }
        if (y != height - 1 && data[y+1][x] <= currentValue) {
            return -1
        }

        return currentValue + 1 // risk level
    }

    companion object {
        fun getRiskLevel(filename: String): Int {
            val map = RiskMap(FileReader.readFileLineAsListOfInts(filename))
            return map.getRiskLevel()
        }

        fun getBasinArea(filename: String): Int {
            val map = RiskMap(FileReader.readFileLineAsListOfInts(filename))
            return map.findBasinArea()
        }
    }
}