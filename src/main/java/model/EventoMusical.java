package model;

import java.util.ArrayList;
import java.util.List;

public class EventoMusical {
	private String nombre;
	private String fecha;
	private String lugar;
	private List<Artista> artistasParticipantes;
	private List<Entrada> entradasDisponibles;

	// Constructor que recibe nombre, fecha y lugar
	public EventoMusical(String nombre, String fecha, String lugar) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.artistasParticipantes = new ArrayList<>();
		this.entradasDisponibles = new ArrayList<>();
	}

	public void agregarArtista(Artista artista) {
		artistasParticipantes.add(artista);
		artista.registrarEvento(this);
	}

	public void removerArtista(Artista artista) {
		artistasParticipantes.remove(artista);
		artista.cancelarParticipacion(this);
	}

	public void cancelarEvento() {
		// Implementa la lógica para cancelar el evento y manejar las entradas asociadas, si es necesario.
	}

	public void venderEntrada(Entrada entrada, Asistente asistente) {
		entradasDisponibles.add(entrada);
		entrada.setAsistenteComprador(asistente);
		asistente.comprarEntrada(entrada);
	}

	public List<Entrada> getEntradasDisponibles() {
		return entradasDisponibles;
	}

	public String obtenerDetallesEvento() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Nombre: ").append(nombre).append("\n");
		detalles.append("Fecha: ").append(fecha).append("\n");
		detalles.append("Lugar: ").append(lugar).append("\n");
		detalles.append("Número de Artistas Participantes: ").append(artistasParticipantes.size()).append("\n");
		detalles.append("Número de Entradas Disponibles: ").append(entradasDisponibles.size()).append("\n");

		return detalles.toString();
	}

	// Métodos adicionales según sea necesario
	public void setArtistasParticipantes(List<Artista> artistasParticipantes) {
		this.artistasParticipantes = artistasParticipantes;
	}

	public List<Artista> getArtistasParticipantes() {
		return this.artistasParticipantes;
	}

	public String getNombreEvento() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
