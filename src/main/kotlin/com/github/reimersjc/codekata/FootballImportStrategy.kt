package com.github.reimersjc.codekata

/**
 * Created by jason on 2/28/17.
 */
class FootballImportStrategy: ImportStrategy {

    val importableRegex = Regex("^\\s+\\d+.\\s+(\\w+)\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+\\s+(\\d+)\\s+-\\s+(\\d+)+\\s+\\d+$")

    override fun isImportable(line: String?): Boolean {
        if (line == null || line == "") {
            return false
        }
        return importableRegex.matches(line)
    }
}