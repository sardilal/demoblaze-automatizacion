package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_DELETE_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BorrarDelCarrito implements Task {
    private String producto;

    public BorrarDelCarrito(String producto) {
        this.producto = producto;
    }

    public static Performable elProducto(String producto) {
        return instrumented(BorrarDelCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_DELETE_PRODUCTO.of(producto))
        );
    }
}