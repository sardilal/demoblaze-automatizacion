package co.com.devco.stepdefinitions;

import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.BorrarDelCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import co.com.devco.tasks.Loguearse;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
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
//Empiezo a agregar steps para el segundo escenario
    @Cuando("{string} agrega el {string} al carrito vacio")
    public void agregarObjetoSinLoguin(String actor, String producto) {
        theActorCalled(actor).attemptsTo(
                Open.url("https://www.demoblaze.com/#"),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto)
        );
    }
    @Dado("{string} agrega {string} y {string} al carrito vacio")
    public void agregarObjetosCarritoVacio(String actor, String producto1, String producto2) {
        theActorCalled(actor).attemptsTo(
                Open.url("https://www.demoblaze.com/#"),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto1),
                Click.on(LINK_HOME),
                AgregarAlCarrito.elProducto(producto2)
        );
    }
    @Cuando("elimina {string}")
    public void eliminarObjetoCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                BorrarDelCarrito.elProducto(producto)
        );
    }

}
