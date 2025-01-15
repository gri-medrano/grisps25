package tests;

import org.testng.annotations.DataProvider;

public abstract class AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return new Object[0][];
    }
}
