package tierraMedia;

import java.util.LinkedList;

/**
 * @author nosotros.grupo
 * 
 * @param presupuesto
 * @param tiempoDisponible
 * @param tipoDeAtraccion
 * @param nombre
 * @param id
 */
public class Usuario {
	private int presupuesto;
	private double tiempoDisponible;
	private int id;
	private TipoAtraccion tipoPreferidoDeAtraccion; 
	private LinkedList<Atraccion> itinerario = new LinkedList<Atraccion>();
	private String name;
	
	public Usuario(int presupuesto, double tiempoDisponible, TipoAtraccion tipoDeAtraccion, String nombre, int id) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferidoDeAtraccion = tipoDeAtraccion;
		this.name = nombre;
		this.id = id;
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public void agregarAtraccion(Atraccion a) {
		itinerario.add(a);
	}
	
	public TipoAtraccion getTipoPreferidoDeAtraccion() {
		return tipoPreferidoDeAtraccion;
	}
	
	/**
	 * @param producto Descuenta el monto del producto al presupuesto - Descuenta el
	 *                 tiempo que le ocupa el producto
	 */
	public void compra(Producto producto) {
		this.presupuesto -= producto.getCostoDeVisita();
		this.tiempoDisponible -= producto.getTiempoPromedioDeVisita();
		producto.disminuirCupo();
		for (Atraccion atrac : producto.getListaDeAtracciones()) {
			this.itinerario.add(atrac);
		}
	}
	
	public int getCostoTotalDeVisita() {
		int costo = 0;
		for (Atraccion atraccion : itinerario) {
			costo += atraccion.getCostoDeVisita();
		}
		return costo;
	}
	
	public double getTiempoTotalDeVisita() {
		int tiempo = 0;
		for (Atraccion atraccion : itinerario) {
			tiempo += atraccion.getTiempoPromedioDeVisita();
		}
		return tiempo;
	}
	
	public String getListaAtracciones() {
		String atraccionesCompradas = "";
		for (Atraccion atrac : itinerario) {
			atraccionesCompradas += "     ==>" + atrac.stringNombreYduracion() + "\n";
		}
		return atraccionesCompradas;
	}

	public LinkedList<Atraccion> getItinerario() {
		return this.itinerario;
	}

	public String getName() {
		return name;
	}
}
