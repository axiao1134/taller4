package gui;

import model.Artista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.PREFERRED_SIZE;

public class VentanaRegistroArtista extends JFrame {
    private JTextField nombreArtisticoTextField;
    private JTextField generoMusicalTextField;
    private JButton registrarArtistaButton;

    public VentanaRegistroArtista() {
        initComponents();
    }

    private void initComponents() {
        JLabel nombreArtisticoLabel = new JLabel("Nombre Artístico:");
        JLabel generoMusicalLabel = new JLabel("Género Musical:");

        nombreArtisticoTextField = new JTextField();
        generoMusicalTextField = new JTextField();
        registrarArtistaButton = new JButton("Registrar Artista");

        registrarArtistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validación de entrada
                String nombreArtistico = nombreArtisticoTextField.getText().trim();
                String generoMusical = generoMusicalTextField.getText().trim();

                if (nombreArtistico.isEmpty() || generoMusical.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaRegistroArtista.this, "Por favor, complete todos los campos.");
                    return;
                }

                try {
                    // Crear una instancia de Artista utilizando el constructor con parámetros
                    Artista nuevoArtista = new Artista(nombreArtistico, generoMusical);

                    // Puedes realizar más acciones según tus necesidades, como agregar el artista a una lista, etc.

                    JOptionPane.showMessageDialog(VentanaRegistroArtista.this, "Artista registrado con éxito.");

                    // Cerrar la ventana después de registrar el artista
                    dispose();
                } catch (Exception ex) {
                    // Manejar cualquier excepción que pueda ocurrir al registrar el artista
                    JOptionPane.showMessageDialog(VentanaRegistroArtista.this,
                            "Error al registrar el artista. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configuración del diseño y disposición de componentes

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreArtisticoLabel)
                                        .addComponent(nombreArtisticoTextField, PREFERRED_SIZE, 200, PREFERRED_SIZE)
                                        .addComponent(generoMusicalLabel)
                                        .addComponent(generoMusicalTextField, PREFERRED_SIZE, 200, PREFERRED_SIZE)
                                        .addComponent(registrarArtistaButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(nombreArtisticoLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreArtisticoTextField, PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(generoMusicalLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generoMusicalTextField, PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, PREFERRED_SIZE)
                        .addComponent(registrarArtistaButton)
                        .addContainerGap(50, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaRegistroArtista ventana = new VentanaRegistroArtista();
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventana.setVisible(true);
            }
        });
    }
}
