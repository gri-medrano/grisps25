package steps;

import factory.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.ByteArrayInputStream;

import static factory.WebDriverManager.driver;

public class Hook {

    @Before(order = 0)
    public synchronized void antes(Scenario scenario) {
        System.out.println("Inicio el driver");
        System.out.println(STR."Inicio scenario name   : \{scenario.getName()}");
        if (driver == null) {
            WebDriverManager.initializeDriver();
        }
    }

    @After(order = 0)
    public synchronized void despues(Scenario scenario) {
        System.out.println("--------------------------------------------------------------");
        System.out.println(STR."Final scenario name   : \{scenario.getName()}");
        System.out.println(STR."Final scenario state  : \{scenario.getStatus()}");
        System.out.println("--------------------------------------------------------------");

        try {
            if (scenario.isFailed()) {
                Allure.addAttachment(
                        "Captura de pantalla al fallar",
                        new ByteArrayInputStream(
                                ((TakesScreenshot) WebDriverManager.getDriver())
                                        .getScreenshotAs(OutputType.BYTES)
                        )
                );
            }
        } catch (Exception e) {
            System.err.println("Error al capturar la captura de pantalla: " + e.getMessage());
        } finally {
            WebDriverManager.closeDriver();
        }
    }
}