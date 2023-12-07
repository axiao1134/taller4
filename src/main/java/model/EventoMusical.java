package model;

import java.util.List;
import java.util.Vector;

public class EventoMusical {
	private String nombre;
	private String fecha;
	private String lugar;
	private List<Artista> artistasParticipantes;
	private List<Entrada> entradasDisponibles;
	private Vector<Artista> artistasAsociados = new Vector<Artista>();
	private Vector<Entrada> entradas = new Vector<Entrada>();

	public void agregarArtista(Artista artista) {
		artistasAsociados.add(artista);
		artista.registrarEvento(this);
	}

	public void removerArtista(Artista artista) {
		artistasAsociados.remove(artista);
		artista.cancelarParticipacion(this);
	}

	public void cancelarEvento() {
		// Lógica para cancelar el evento y manejar las entradas asociadas, si es necesario.
	}

	public void venderEntrada(Entrada entrada, Asistente asistente) {
		entradas.add(entrada);
		entrada.setAsistenteComprador(asistente);
		asistente.comprarEntrada(entrada);
	}

	public String obtenerDetallesEvento() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Nombre: ").append(nombre).append("\n");
		detalles.append("Fecha: ").append(fecha).append("\n");
		detalles.append("Lugar: ").append(lugar).append("\n");
		detalles.append("Número de Artistas Participantes: ").append(artistasAsociados.size()).append("\n");
		detalles.append("Número de Entradas Disponibles: ").append(entradasDisponibles.size()).append("\n");

		return detalles.toString();
	}

	public void setArtistasParticipantes(List<Artista> artistasParticipantes) {
		this.artistasParticipantes = artistasParticipantes;
	}

	public List<Artista> getArtistasParticipantes() {
		return this.artistasParticipantes;
	}

	public String getNombreEvento() {
		return nombre;
	}
}
