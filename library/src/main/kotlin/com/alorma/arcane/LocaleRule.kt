package com.alorma.arcane

open class LocaleRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                setLanguageForTest(Locale.UK)
                base.evaluate()
            }
        }
    }

    fun setLanguageForTest(locale: Locale) {
        val resources = InstrumentationRegistry.getTargetContext().getResources()
        Locale.setDefault(locale)
        val config = resources.getConfiguration()
        config.locale = locale
        resources.updateConfiguration(config, resources.getDisplayMetrics())
    }
}