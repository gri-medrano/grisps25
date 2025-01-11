package VarStatic;

import actions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class VarStatic {
    public static WebDriver driver;
    public static BuscarElemento buscar;
    public static Actions actions = new Actions(driver);
    public static EsperarHasta esperar;
    public static Acciones accion;
    public static ElementoResaltado resaltar;
    public static JavaScript javaScript;
    public static String ventanaPrincipal; // Variable para almacenar la ventana principal

    public static String ultimaVentana; // Variable para almacenar la última ventana



}
