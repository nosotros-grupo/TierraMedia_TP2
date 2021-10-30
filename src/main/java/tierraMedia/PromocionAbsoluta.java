package tierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private double precioFinal;
	private String nombre = "ABSOLUTA";
	
	public PromocionAbsoluta(double precio, List<Atraccion> atracciones) {
		super(atracciones);
		this.precioFinal = precio;
	}

	public double getCostoDeVisita() {
		return this.precioFinal;
	}

	@Override
	public boolean contiene(Producto p) {
		return false;
	}

	@Override
	public String toString() {
		Integer costoMonedas = (int) this.precioFinal;
		String frase2 = String.format("%1$" + 2 + "s", costoMonedas.toString());
		
		return "\n Promo \"" + this.nombre + "\"  << Precio Promocional " 
			+ frase2 + " monedas >>   Incluye  "+ atraccionesEnPromo + "\n";
	}
}