package factory;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;

public class CreatorEdgeDriver {
    public static org.openqa.selenium.WebDriver createWebDriver() {
        EdgeOptions optionsEdge = new EdgeOptions();
        optionsEdge.addArguments("--start-maximized");
        optionsEdge.addArguments("--disable-extensions");
        if (ConfigReader.isHeadlessModeEnabled()) {
            optionsEdge.addArguments("--headless");
        }
        return new EdgeDriver(optionsEdge);
    }
}


