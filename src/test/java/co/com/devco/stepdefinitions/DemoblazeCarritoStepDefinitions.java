package co.com.devco.stepdefinitions;

import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import co.com.devco.tasks.Loguearse;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeCarritoStepDefinitions {

    @Dado("que {string} se loguea como {string}")
    public void loguin(String actor, String rol) {
        theActorCalled(actor).attemptsTo(
                Loguearse.como(rol)
        );
    }

    @Cuando("agrega el {string} al carrito vacio")
    public void agregarObjetoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto)
        );
    }
    @Entonces("debe ver como unico elemento el {string}")
    public void verificarObjetoCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRODUCTOS_CARRITO).values().hasSize(1),
                Ensure.that(Text.of(TITULO_PRODUCTO_CARRITO)).isEqualToIgnoringCase(producto)
        );

    }

}
