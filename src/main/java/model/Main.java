package model;

import gui.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear algunos datos de prueba
        List<EventoMusical> eventos = new ArrayList<>();
        EventoMusical evento1 = new EventoMusical("Concierto1", "2023-01-01", "Lugar1");
        EventoMusical evento2 = new EventoMusical("Concierto2", "2023-02-01", "Lugar2");
        eventos.add(evento1);
        eventos.add(evento2);

        // Crear y mostrar las ventanas
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Ventana de Registro de Artista
                VentanaRegistroArtista ventanaRegistroArtista = new VentanaRegistroArtista();
                ventanaRegistroArtista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaRegistroArtista.setVisible(true);

                // Ventana de Registro de Asistente
                VentanaRegistroAsistente ventanaRegistroAsistente = new VentanaRegistroAsistente();
                ventanaRegistroAsistente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaRegistroAsistente.setVisible(true);

                // Ventana de Registro de Evento
                VentanaRegistroEvento ventanaRegistroEvento = new VentanaRegistroEvento();
                ventanaRegistroEvento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaRegistroEvento.setVisible(true);

                // Ventana de Venta de Entrada
                VentanaVentaEntrada ventanaVentaEntrada = new VentanaVentaEntrada(eventos);
                ventanaVentaEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaVentaEntrada.setVisible(true);

                // Ventana de Cancelación de Evento (usando el primer evento como ejemplo)
                VentanaCancelacionEvento ventanaCancelacionEvento = new VentanaCancelacionEvento(evento1);
                ventanaCancelacionEvento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaCancelacionEvento.setVisible(true);
            }
        });
    }
}
