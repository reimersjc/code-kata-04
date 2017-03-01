package com.github.reimersjc.codekata


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class DataMungerSpec : Spek({

    describe("weather data") {
        it("should result in day 14 having the smallest spread between max and min temperature") {
            val munger = DataMunger<WeatherData>(WeatherImportStrategy())
            val result = munger.mung("weather.dat", WeatherData::class.java)
            println("Day with the smallest spread is ${result.day}\n")
            assertEquals(14, result.day)
        }
    }

    describe("football data") {
        it ("should result in team 'Aston_Villa' having the smallest spread between scores for and against") {
            val munger = DataMunger<FootballData>(FootballImportStrategy())
            val result = munger.mung("football.dat", FootballData::class.java)
            println("Team with the smallest spread between wins for and againts is ${result.teamName}\n")
            assertEquals("Aston_Villa", result.teamName)
        }
    }
})