package tierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	private List<Atraccion> atraccionesBonificadas;
	private String nombre = "AXB";

	public PromocionAxB(List<Atraccion> atracciones, List<Atraccion> atraccionesBonificadas) {
		super(atracciones);
		this.atraccionesBonificadas = atraccionesBonificadas;
		this.atraccionesEnPromo.addAll(atraccionesBonificadas);
	}

	public TipoAtraccion getTipoAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}

	public double getCostoDeVisita() {
		double costoDeVisita = 0;
		for (Atraccion atraccion : atraccionesEnPromo) {
			if (!atraccionesBonificadas.contains(atraccion)) {
				costoDeVisita += atraccion.getCostoDeVisita();
			}
		}
		return costoDeVisita;
	}

	@Override
	public boolean contiene(Producto p) {
		return false;
	}

	@Override
	public String toString() {
		Double costoMonedas = this.getCostoDeVisita();
		String frase2 = String.format("%1$" + 2 + "s", costoMonedas.toString());
		return "\n Promo \"" + this.nombre + "\"  << Precio Promocional " + frase2 +" " + " monedas >>   Incluye  "
				+ atraccionesEnPromo + "\n Y SIN CARGO!!    Esta atracción para que disfrute al máximo:   " 
				+ atraccionesBonificadas + "\n";
	}
}
