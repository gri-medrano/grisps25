package actions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import factory.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import java.util.List;

import static VarStatic.VarStatic.*;

public class Click {
    public static void ClickearJs(By locator) throws Exception {
        clickearElemento(locator, true);
    }

    public static void Clickear(By locator) throws Exception {
        clickearElemento(locator, false);
    }

    public static void hacerClickEnElementos(By locator) {
        try {
            // Obtener el WebDriver desde la sesión
            WebDriver driver = Session.getWebDriver();

            // Validar que el WebDriver no sea nulo
            if (driver == null) {
                throw new Exception("El WebDriver no está inicializado en la sesión.");
            }

            // Encontrar los elementos por el localizador
            List<WebElement> elementos = driver.findElements(locator);

            if (elementos != null && !elementos.isEmpty()) {
                for (WebElement elemento : elementos) {
                    // Realizar acciones adicionales antes de hacer clic
                    accion.hacerScroll(elemento);
                    elemento.click();
                }
            } else {
                System.out.println("La lista de elementos está vacía o es nula.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void clickearElemento(By locator, boolean usarJs) throws Exception {
        try {
            WebElement elemento = esperar.presente(locator);
            String colorEnabled = ConfigReader.obtenerHabilitacionColor();
            if (elemento != null) {
                javaScript.scrollLocator(locator);
                if ("true".equalsIgnoreCase(colorEnabled)) {
                    resaltar.resaltar(elemento);
                }
                if (usarJs) {
                    javaScript.click(elemento);
                } else {
                    elemento.click();
                }
            } else {
                throw new Exception("El elemento no se encontró o no es clickeable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
