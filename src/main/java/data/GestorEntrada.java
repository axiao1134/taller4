package data;

import model.Entrada;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorEntrada {
    private static final String ENTRADAS_FILE = "entradas.txt"; // Archivo para almacenar datos de entradas

    private static List<Entrada> entradas = cargarEntradas(); // Cargar entradas al iniciar

    public static void registrarEntrada(Entrada entrada) {
        entradas.add(entrada);
        guardarEntradas();
    }

    public static List<Entrada> obtenerEntradas() {
        return new ArrayList<>(entradas);
    }

    private static List<Entrada> cargarEntradas() {
        if (Files.exists(Paths.get(ENTRADAS_FILE))) {
            // Si el archivo existe, realiza la carga desde el archivo
            // Implementa la lógica de lectura desde el archivo y retorna la lista
        }
        return new ArrayList<>();
    }

    private static void guardarEntradas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ENTRADAS_FILE))) {
            // Lógica para escribir la información de las entradas en el archivo
            for (Entrada entrada : entradas) {
                writer.write(entrada.toString()); // Ajusta según la representación en String de Entrada
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de excepciones, ajusta según tus necesidades.
        }
    }
}
