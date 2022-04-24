package co.com.devco.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeCarritoPage {
	public static final Target TITULO_PRODUCTO_CARRITO = Target.the("titulo del producto del carrito").locatedBy("/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
	public static final Target PRODUCTOS_CARRITO = Target.the("productos del carrito").locatedBy("//tbody[@id='tbodyid']/tr");
	public static final Target LINK_PRIMER_DELETE_PRODUCTOS_CARRITO = Target.the("Link para borrado de productos del carrito").locatedBy("//tbody[@id='tbodyid']/tr[1]//a[text()='Delete']");
	public static final Target PRODUCTOS_CARRITO_TIPO = Target.the("productos del carrito del tipo {0}").locatedBy("//tbody[@id='tbodyid']//td[text()='{0}']/..");
}
