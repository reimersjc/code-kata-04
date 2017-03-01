package com.github.reimersjc.codekata

import com.ancientprogramming.fixedformat4j.annotation.Field
import com.ancientprogramming.fixedformat4j.annotation.Record

@Record
class FootballData (
        @get:Field(offset = 8, length = 16) var teamName: String,
        @get:Field(offset = 44, length = 2) var scoreFor: Int,
        @get:Field(offset = 51, length = 2) var scoreAgainst: Int): Spreadable<Int> {

    /*
     * FIXME: fixedformat4j needs a no-arg constructor
     */
    constructor(): this("", 0, 0) {}

    override fun getSpread(): Int {
        return Math.abs(scoreFor - scoreAgainst)
    }

    override fun toString(): String {
        return "FootballData(teamName='$teamName', scoreFor=$scoreFor, scoreAgainst=$scoreAgainst)"
    }

}