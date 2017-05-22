package com.alorma.arcane

import android.os.Build
import android.support.test.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.*

open class LocaleRule(val checkLocales: Array<String>? = null) : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                val context = InstrumentationRegistry.getTargetContext()

                val locales = checkLocales ?: context.assets.locales

                for (localeTag in locales) {
                    val locale: Locale? = getLocaleForTest(localeTag)
                    if (locale != null) {
                        setLanguageForTest(locale)
                        base.evaluate()
                    }
                }
            }
        }
    }

    private fun getLocaleForTest(localeTag: String): Locale? {
        if (!localeTag.isEmpty()) {
            return getLocaleForTag(localeTag)
        } else {
            return Locale.getDefault()
        }
    }

    private fun getLocaleForTag(localeTag: String): Locale {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return Locale.forLanguageTag(localeTag)
        } else {
            return Locale(localeTag)
        }
    }

    fun setLanguageForTest(locale: Locale) {
        val resources = InstrumentationRegistry.getTargetContext().resources
        Locale.setDefault(locale)
        val config = resources.configuration
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}