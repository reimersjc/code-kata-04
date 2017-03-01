package com.github.reimersjc.codekata

import com.ancientprogramming.fixedformat4j.annotation.Align
import com.ancientprogramming.fixedformat4j.annotation.Field
import com.ancientprogramming.fixedformat4j.annotation.Record

@Record
class WeatherData(
        @get:Field(offset = 1, length = 4, align = Align.RIGHT) var day: Int,
        @get:Field(offset = 5, length = 4, align = Align.RIGHT) var maxTemp: Int,
        @get:Field(offset = 10, length = 4, align = Align.RIGHT) var minTemp: Int): Spreadable<Int> {

    /*
     * FIXME: fixedformat4j needs a no-arg constructor
     */
    constructor(): this(0, 0, 0) {}

    override fun getSpread(): Int {
        return Math.abs(Math.abs(maxTemp) - Math.abs(minTemp))
    }

    override fun toString(): String {
        return "WeatherData(day=$day, maxTemp=$maxTemp, minTemp=$minTemp)"
    }

}