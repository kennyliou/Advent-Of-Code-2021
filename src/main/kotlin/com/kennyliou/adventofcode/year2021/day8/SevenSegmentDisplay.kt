package com.kennyliou.adventofcode.year2021.day8

class SevenSegmentDisplay(hints: List<String>, private val displays: List<String>) {
    val letterCounts = mutableMapOf<Char, Int>()
    val letterValues = mutableMapOf<Char, Int>()

    // We first use 1, 4, 7, 8 to decode which letter represent which position, through 0-9, each segment shows up
    // the following times:
    //    top: 8
    //    top_left:6
    //    top_right: 8
    //    middle: 7
    //    bottom_left: 4
    //    bottom_right: 9
    //    bottom: 7
    // Each segment position has a number that represent them
    //    1, 2, 4, 8, 16, 32, 64
    //    0101
    //  02    04
    //  02    04
    //    0808
    //  16    32
    //  16    32
    //    6464
    // Once we figured out which letter is which segment position, we can them sum them up to get the correct digit:
    //   1: 4 + 32 = 36
    //   2: 1 + 4 + 8 + 16 + 64 = 93
    //   3: 1 + 4 + 8 + 32 + 64 = 109
    //   4: 2 + 4 + 8 + 32 = 46
    //   5: 1 + 2 + 8 + 32 + 64 = 107
    //   6: 1 + 2 + 8 + 16 + 32 + 64 = 123
    //   7: 1 + 4 + 32 = 37
    //   8: 1 + 2 + 4 + 8 + 16 + 32 + 64 = 127
    //   9: 1 + 2 + 4 + 8 + 32 + 64 = 111
    init {

        // construct letter counts
        hints.map { word->
            word.groupingBy { c: Char ->
                c
            }.eachCountTo(letterCounts)
        }
        // use 1 to determine top_right and bottom_right
        val one = hints.filter { it.length == 2 }[0].toCharArray()
        if (letterCounts[one[0]] == 8) {
            // one[0] is top_right
            letterValues[one[0]] = 4
            letterValues[one[1]] = 32
        } else {
            // one[0] is bottom_right
            letterValues[one[0]] = 32
            letterValues[one[1]] = 4
        }

        // use 7 to determine top value
        val seven = hints.filter { it.length == 3 }[0].toCharArray().toMutableList()
        seven.remove(one[0])
        seven.remove(one[1])
        letterValues[seven[0]] = 1

        // use 4 to determine top_left and middle
        val four = hints.filter { it.length == 4 }[0].toCharArray().toMutableList()
        four.remove(one[0])
        four.remove(one[1])
        if (letterCounts[four[0]] == 6) {
            // four[0] is top_left
            letterValues[four[0]] = 2
            letterValues[four[1]] = 8
        } else {
            // four[0] is middle
            letterValues[four[0]] = 8
            letterValues[four[1]] = 2
        }

        val eight = hints.filter { it.length == 7 }[0].toCharArray().toMutableList()
        eight.remove(one[0])
        eight.remove(one[1])
        eight.remove(seven[0])
        eight.remove(four[0])
        eight.remove(four[1])
        if (letterCounts[eight[0]] == 4) {
            // eight[0] is bottom_left
            letterValues[eight[0]] = 16
            letterValues[eight[1]] = 64
        } else {
            // eight[0] is bottom
            letterValues[eight[0]] = 64
            letterValues[eight[1]] = 16
        }
    }


    // return how many 1, 4, 7, and 8 shows up on the displays data
    fun countSimpleNumbers(): Int {
        return displays.count { input ->
            input.length == 2 || input.length == 3 || input.length == 4 || input.length == 7
        }
    }

    fun getSegmentValue(): Int {
        var result = 0
        displays.map {
            result = result * 10 + getFragmentValue(it)
        }
        return result
    }

    private fun getFragmentValue(fragments: String): Int {
        val value = fragments.toCharArray().sumOf {
            letterValues[it]!!
        }
        return when(value) {
            36 -> 1
            93 -> 2
            109 -> 3
            46 -> 4
            107 -> 5
            123 -> 6
            37 -> 7
            127 -> 8
            111 -> 9
            else -> Int.MIN_VALUE
        }
    }
}