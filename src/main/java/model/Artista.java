package model;

import java.util.ArrayList;
import java.util.List;

public class Artista {
	private String nombreArtistico;
	private String generoMusical;
	private List<EventoMusical> eventosParticipados;

	public Artista(String nombreArtistico, String generoMusical) {
		this.nombreArtistico = nombreArtistico;
		this.generoMusical = generoMusical;
		this.eventosParticipados = new ArrayList<>();
	}

	public void registrarEvento(EventoMusical eventoMusical) {
		eventosParticipados.add(eventoMusical);
		eventoMusical.agregarArtista(this);
	}

	public void cancelarParticipacion(EventoMusical eventoMusical) {
		eventosParticipados.remove(eventoMusical);
		eventoMusical.removerArtista(this);
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public List<EventoMusical> getEventosParticipados() {
		return new ArrayList<>(eventosParticipados);
	}

	public String obtenerDetallesArtista() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Nombre Artístico: ").append(nombreArtistico).append("\n");
		detalles.append("Género Musical: ").append(generoMusical).append("\n");
		detalles.append("Eventos Participados: ").append(eventosParticipados.size()).append("\n");

		return detalles.toString();
	}
}
