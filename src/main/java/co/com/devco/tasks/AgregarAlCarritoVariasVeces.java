package co.com.devco.tasks;

import co.com.devco.interactions.ClickAgregarCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarritoVariasVeces implements Task {
    private String producto;
    private int veces;

    public AgregarAlCarritoVariasVeces(String producto, int veces) {
        this.producto = producto;
        this.veces = veces;
    }

    public static Performable elProductoNVeces(String producto, int veces) {
        return instrumented(AgregarAlCarritoVariasVeces.class, producto, veces);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_PRODUCTO.of(producto)),
                ClickAgregarCarrito.veces(veces),
                WaitUntil.the(LINK_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(6)),
                Click.on(LINK_CARRITO)
        );
    }
}
