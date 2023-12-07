package model;

import java.util.List;

public class Asistente {
	private String nombre;
	private String informacionContacto;
	private List<String> preferenciasMusicales;
	private List<Entrada> entradasCompradas;

	public void comprarEntrada(Entrada entrada) {
		entradasCompradas.add(entrada);
		entrada.setAsistenteComprador(this);
	}

	public void cancelarEntrada(Entrada entrada) {
		entradasCompradas.remove(entrada);
		entrada.setAsistenteComprador(null);
	}

	public String obtenerDetallesAsistente() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Nombre: ").append(nombre).append("\n");
		detalles.append("Información de Contacto: ").append(informacionContacto).append("\n");
		detalles.append("Preferencias Musicales: ").append(preferenciasMusicales).append("\n");
		detalles.append("Entradas Compradas: ").append(entradasCompradas.size()).append("\n");

		return detalles.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
