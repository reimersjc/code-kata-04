package com.github.reimersjc.codekata

import kotlin.comparisons.compareBy

/**
 * Created by jason on 2/28/17.
 */
class DataMunger<T : Spreadable<Int>>(private val importStrategy: ImportStrategy) {

    fun mung(file: String, clazz: Class<T>): T {
        val importer = DataImporter<T>(importStrategy)
        val data = importer.importData(file, clazz).sortedWith(compareBy { it.getSpread() })
        return data[0]
    }

}