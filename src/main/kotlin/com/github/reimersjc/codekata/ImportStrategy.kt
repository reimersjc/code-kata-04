package com.github.reimersjc.codekata

/**
 * Created by jason on 2/28/17.
 */
interface ImportStrategy {

    fun isImportable(line: String?): Boolean

}