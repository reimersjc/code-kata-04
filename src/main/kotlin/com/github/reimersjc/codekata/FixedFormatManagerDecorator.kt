package com.github.reimersjc.codekata

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager

/**
 * Created by jason on 2/28/17.
 */
class FixedFormatManagerDecorator(
        val manager: FixedFormatManager,
        val importStrategy: ImportStrategy) : FixedFormatManager {

    override fun <T : Any?> export(instance: T): String {
        return manager.export(instance)
    }

    override fun <T : Any?> export(data: String?, instance: T): String {
        return manager.export(data, instance)
    }

    /**
     * Override load to not load a record that the import strategy
     * indicates as not importable.
     */
    override fun <T : Any?> load(clazz: Class<T>?, data: String?): T? {
        if (importStrategy.isImportable(data)) {
            return manager.load(clazz, data)
        } else {
            return null
        }
    }
}