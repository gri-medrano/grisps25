import actions.Click;
import actions.Escribir;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static VarStatic.HomeStatic.INPUT_BUSCADOR_AEROPUERTO;
import static VarStatic.HomeStatic.NUESTROS_AEROPUERTOS;

public class stepHome {
    @Dado("que ingreso a nuestros aeropuertos")
    public void queIngresoANuestrosAeropuertos() throws Exception {
        Click.Clickear(NUESTROS_AEROPUERTOS);
    }

    @Entonces("hago click en Tucuman")
    public void hagoClickEnTucuman() throws Exception {
        Click.Clickear(INPUT_BUSCADOR_AEROPUERTO);
        Escribir.Escribir(INPUT_BUSCADOR_AEROPUERTO, "Tucuman");
    }
}
