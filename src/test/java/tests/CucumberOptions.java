package tests;

public @interface CucumberOptions {
    String[] plugin();

    String glue();

    String features();

    String tags();
}
