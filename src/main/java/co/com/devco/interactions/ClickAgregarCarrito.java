package co.com.devco.interactions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_PRIMER_DELETE_PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickAgregarCarrito implements Interaction {
    private int veces;

    public ClickAgregarCarrito(int veces) {
        this.veces = veces;
    }

    public static ClickAgregarCarrito veces(int veces){
        return new ClickAgregarCarrito(veces);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < veces; i++){
            actor.attemptsTo(Click.on(BOTON_AGREGAR_CARRITO));
            WaitUntil.the(BOTON_AGREGAR_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(6));
        }
    }
}
