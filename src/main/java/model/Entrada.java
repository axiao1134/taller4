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

	public Entrada(EventoMusical eventoAsistido, double precio) {
		this.tipo = "Tipo Predeterminado"; // Proporciona un tipo predeterminado o ajusta según sea necesario
		this.precio = precio;
		this.eventoAsistido = eventoAsistido;
	}

	@Override
	public String toString() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Tipo: ").append(tipo).append("\n");
		detalles.append("Precio: ").append(precio).append("\n");
		detalles.append("Evento Asistido: ").append((eventoAsistido != null) ? eventoAsistido.getNombreEvento() : "No asignado").append("\n");
		detalles.append("Asistente Comprador: ").append((asistenteComprador != null) ? asistenteComprador.getNombre() : "No asignado").append("\n");

		return detalles.toString();
	}

	// Métodos adicionales según sea necesario
	public void setAsistenteComprador(Asistente asistenteComprador) {
		this.asistenteComprador = asistenteComprador;
	}
}
