# Android Espresso locales

Run espresso tests in multiple *Locale*

The tool consists in a client library to run test with multiple locales

# Usage

Just use the `LocaleRule` in your Espresso tests:

```java
class MyTest {
  // ...
  @Rule
  public LocaleRule localeRule = new LocaleRule();

  @Test
  public void myTest(){
    assert(R.string.hello_world);
  }

}
```

```java
class MyTest {
  // ...
  @Rule
  public LocaleRule localeRule = new LocaleRule(new String[] { "en", "es", "it" });

  @Test
  public void myTest(){
    assert(R.string.hello_world);
  }

}
```

# Install ( **TODO** )

```groovy

dependencies {

  compile 'com.github.alorma:arcane:0.0.1'

}

```

Now you can run your usual `connectedAndroidTest` tasks.

# How it works

Magic!

_No, really, I have to fill this section at some point._

## Thanks

[@Sloy](https://github.com/sloy), i take inspiration of his [android-screenshot-reporter](https://github.com/Sloy/android-screenshot-reporter) plugin