package gui;// ... (imports y código existente)

import model.Artista;
import model.Entrada;
import model.EventoMusical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistroEvento extends JFrame {
    private JTextField nombreTextField;
    private JTextField fechaTextField;
    private JTextField lugarTextField;
    private JButton registrarEventoButton;

    private List<Artista> artistasParticipantes;
    private List<Entrada> entradasDisponibles;

    public VentanaRegistroEvento() {
        artistasParticipantes = new ArrayList<>();
        entradasDisponibles = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        JLabel nombreLabel = new JLabel("Nombre del Evento:");
        JLabel fechaLabel = new JLabel("Fecha (YYYY-MM-DD):");
        JLabel lugarLabel = new JLabel("Lugar del Evento:");

        nombreTextField = new JTextField();
        fechaTextField = new JTextField();
        lugarTextField = new JTextField();
        registrarEventoButton = new JButton("Registrar Evento");

        registrarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validación de entrada
                String nombre = nombreTextField.getText().trim();
                String fecha = fechaTextField.getText().trim();
                String lugar = lugarTextField.getText().trim();

                if (nombre.isEmpty() || fecha.isEmpty() || lugar.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaRegistroEvento.this, "Por favor, complete todos los campos.");
                    return;
                }

                // Lógica para registrar evento
                EventoMusical nuevoEvento = new EventoMusical("Concierto1", "2023-01-01", "Lugar1");
                nuevoEvento.setNombre(nombre);
                nuevoEvento.setFecha(fecha);
                nuevoEvento.setLugar(lugar);

                // Puedes manejar los artistas participantes y las entradas disponibles según tus necesidades.

                // Puedes realizar más acciones según tus necesidades, como agregar el evento a una lista, etc.

                JOptionPane.showMessageDialog(VentanaRegistroEvento.this, "Evento registrado con éxito.");
                // Puedes cerrar la ventana o realizar otras acciones según tus necesidades.
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
                                        .addComponent(nombreLabel)
                                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fechaLabel)
                                        .addComponent(fechaTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lugarLabel)
                                        .addComponent(lugarTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registrarEventoButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(nombreLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechaLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lugarLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lugarTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrarEventoButton)
                        .addContainerGap(50, Short.MAX_VALUE));

        pack();
    }
}
