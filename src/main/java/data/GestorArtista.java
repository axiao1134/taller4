package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Artista;

public class GestorArtista {
    private static final List<Artista> artistas = new ArrayList<>();
    private static final String ARCHIVO_ARTISTAS = "artistas.txt";

    public static void registrarArtista(Artista artista) {
        artistas.add(artista);
        guardarArtistasEnArchivo();
    }

    public static List<Artista> obtenerArtistas() {
        cargarArtistasDesdeArchivo();
        return new ArrayList<>(artistas); // Devuelve una copia para evitar modificaciones no deseadas.
    }

    private static void guardarArtistasEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ARTISTAS))) {
            oos.writeObject(artistas);
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes registrar o relanzar la excepción según tus necesidades.
        }
    }

    private static void cargarArtistasDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_ARTISTAS))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                artistas.clear(); // Borra la lista actual antes de cargar la nueva.
                artistas.addAll((List<Artista>) obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Puede ser la primera ejecución o no hay artistas guardados.
            // Puedes registrar o relanzar la excepción según tus necesidades.
        }
    }
}
