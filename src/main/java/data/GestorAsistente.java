package data;

import model.Asistente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorAsistente {
    private static final String ASISTENTES_FILE = "asistentes.txt"; // Archivo para almacenar datos de asistentes

    private static List<Asistente> asistentes = cargarAsistentes(); // Cargar asistentes al iniciar

    public static void registrarAsistente(Asistente asistente) {
        asistentes.add(asistente);
        guardarAsistentes();
    }

    private static List<Asistente> cargarAsistentes() {
        if (Files.exists(Paths.get(ASISTENTES_FILE))) {
            // Si el archivo existe, realiza la carga desde el archivo
            // Implementa la lógica de lectura desde el archivo y retorna la lista
        }
        return new ArrayList<>();
    }

    private static void guardarAsistentes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ASISTENTES_FILE))) {
            // Lógica para escribir la información de los asistentes en el archivo
            for (Asistente asistente : asistentes) {
                writer.write(asistente.toString()); // Ajusta según la representación en String de Asistente
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de excepciones, ajusta según tus necesidades.
        }
    }
}
