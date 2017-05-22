package com.alorma.myapplication;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.alorma.arcane.LocaleRule;
import com.alorma.arcane.sample.MainActivity;
import com.alorma.arcane.sample.R;
import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.BaristaAssertions.assertDisplayed;

public class ActivityLanguagesTest {

    @Rule public LocaleRule localeRule = new LocaleRule(new String[] { "en", "es", "it" });

    @Rule public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void run_languages() {
        assertDisplayed(InstrumentationRegistry.getTargetContext().getString(R.string.hello_world));
    }
}
