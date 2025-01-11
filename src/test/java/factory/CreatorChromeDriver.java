package factory;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class CreatorChromeDriver {
    public static WebDriver createWebDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        optionsChrome.addArguments("--disable-extensions");
        if (ConfigReader.isHeadlessModeEnabled()) {
            optionsChrome.addArguments("--headless");
        }
        return new ChromeDriver();
    }
}
