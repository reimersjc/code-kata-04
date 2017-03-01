package com.github.reimersjc.codekata

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl
import java.io.BufferedReader
import java.io.InputStreamReader

class DataImporter<T : Spreadable<Int>>(private val importStrategy: ImportStrategy) {

    fun importData(file: String, clazz: Class<T>): List<T> {
        val data = mutableListOf<T>()
        val manager: FixedFormatManager = FixedFormatManagerDecorator(FixedFormatManagerImpl(), importStrategy)
        BufferedReader(InputStreamReader(this.javaClass.classLoader.getResourceAsStream(file), "UTF-8"))
                .forEachLine { line ->
                    run {
                        val record = manager.load(clazz, line)
                        if (record != null) {
                            data.add(record)
                        }
                    }
                }
        return data
    }
}