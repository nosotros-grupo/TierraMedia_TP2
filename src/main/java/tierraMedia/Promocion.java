package tierraMedia;

import java.util.List;

public abstract class Promocion implements Producto {
	protected List<Atraccion> atraccionesEnPromo;

	public Promocion(List<Atraccion> atracciones) {
		this.atraccionesEnPromo = atracciones;
	}

	public Promocion() {
	}

	public TipoAtraccion getTipoDeAtraccion() {
		return atraccionesEnPromo.get(0).getTipoDeAtraccion();
	}

	public double getTiempoPromedioDeVisita() {
		int hora = 0;
		double minutos = 0;
		for (Atraccion atraccion : atraccionesEnPromo) {
			double tiempoDeVisita = atraccion.getTiempoPromedioDeVisita();
			hora += (int) tiempoDeVisita;
			minutos += (10 * atraccion.getTiempoPromedioDeVisita() - 10 * hora)/10;
		}
		hora = hora * 60;
		return (hora + minutos) / 60;
	}

	public boolean esPromocion() {
		return true;
	}
	
	public boolean tieneCupo() {
		boolean cupo = false;
		for (Atraccion atraccion : atraccionesEnPromo) {
			if (atraccion.tieneCupo()) {
				cupo = true;
			} 
		}return cupo;
	}
	
	
	public List<Atraccion> getListaDeAtracciones() {
		return this.atraccionesEnPromo;
	}
	
	public void disminuirCupo() {
		for (Atraccion atraccion : atraccionesEnPromo) {
			atraccion.disminuirCupo();
		}
	}
	
	public int compareTo(Producto o2) {
		// Primero Ofrece Promociones
		if (this.esPromocion() && !o2.esPromocion()) {
			return -1;
		} else if (!this.esPromocion() && o2.esPromocion()) {
			return 1;
		}
		// si no se da ese caso se prioriza la más maca
		double diferencia = o2.getCostoDeVisita() - this.getCostoDeVisita();
		if (diferencia != 0) {
			return (int) diferencia;
		}
		// Si tienen el mismo precio
		return (int) (o2.getTiempoPromedioDeVisita() - this.getTiempoPromedioDeVisita());
	}

	public boolean contiene(Producto p) {
		// TODO Auto-generated method stub
		return false;
	}

}
