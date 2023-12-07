package model;

import java.util.List;
import java.util.Vector;

public class Artista {
	private String nombreArtistico;
	private String generoMusical;
	private List<EventoMusical> eventosParticipados;
	private Vector<EventoMusical> eventosMusicales = new Vector<EventoMusical>();

	public void registrarEvento(EventoMusical eventoMusical) {
		eventosMusicales.add(eventoMusical);
		eventoMusical.agregarArtista(this);
	}

	public void cancelarParticipacion(EventoMusical eventoMusical) {
		eventosMusicales.remove(eventoMusical);
		eventoMusical.removerArtista(this);
	}

	public String obtenerDetallesArtista() {
		StringBuilder detalles = new StringBuilder();
		detalles.append("Nombre Artístico: ").append(nombreArtistico).append("\n");
		detalles.append("Género Musical: ").append(generoMusical).append("\n");
		detalles.append("Eventos Participados: ").append(eventosParticipados.size()).append("\n");

		return detalles.toString();
	}
}
