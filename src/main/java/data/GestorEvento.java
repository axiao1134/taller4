package data;

import model.EventoMusical;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorEvento {
    private static final String EVENTOS_FILE = "eventos.txt"; // Archivo para almacenar datos de eventos

    private static List<EventoMusical> eventos = cargarEventos(); // Cargar eventos al iniciar

    public static void registrarEvento(EventoMusical evento) {
        eventos.add(evento);
        guardarEventos();
    }

    public static List<EventoMusical> obtenerEventos() {
        return new ArrayList<>(eventos);
    }

    private static List<EventoMusical> cargarEventos() {
        if (Files.exists(Paths.get(EVENTOS_FILE))) {
            // Si el archivo existe, realiza la carga desde el archivo
            // Implementa la lógica de lectura desde el archivo y retorna la lista
        }
        return new ArrayList<>();
    }

    private static void guardarEventos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EVENTOS_FILE))) {
            // Lógica para escribir la información de los eventos en el archivo
            for (EventoMusical evento : eventos) {
                writer.write(evento.toString()); // Ajusta según la representación en String de EventoMusical
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de excepciones, ajusta según tus necesidades.
        }
    }
}
