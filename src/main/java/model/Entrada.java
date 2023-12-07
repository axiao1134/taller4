package model;

public class Entrada {
	private String tipo;
	private Double precio;
	private EventoMusical eventoAsistido;
	private Asistente asistenteComprador;

	public Entrada(String tipo, Double precio, EventoMusical eventoAsistido) {
		this.tipo = tipo;
		this.precio = precio;
		this.eventoAsistido = eventoAsistido;
	}

	public String obtenerDetallesEntrada() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Tipo: ").append(tipo).append("\n");
		detalles.append("Precio: ").append(precio).append("\n");
		detalles.append("Evento Asistido: ").append(eventoAsistido.getNombreEvento()).append("\n");

		if (asistenteComprador != null) {
			detalles.append("Asistente Comprador: ").append(asistenteComprador.getNombre()).append("\n");
		} else {
			detalles.append("Asistente Comprador: No asignado\n");
		}

		return detalles.toString();
	}

	// Métodos adicionales según sea necesario
	public void setAsistenteComprador(Asistente asistenteComprador) {
		this.asistenteComprador = asistenteComprador;
	}
}
