package com.github.reimersjc.codekata

/**
 * Created by jason on 2/28/17.
 */
class WeatherImportStrategy : ImportStrategy {

    val importableRegex = Regex("^ +(\\d+) +(\\d+) +(\\d+).+$")

    override fun isImportable(line: String?): Boolean {
        if (line == null || line == "") {
            return false
        }
        return importableRegex.matches(line)
    }
}