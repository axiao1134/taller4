package gui;

import model.EventoMusical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCancelacionEvento extends JFrame {
    private JLabel nombreEventoLabel;
    private JButton cancelarEventoButton;

    private EventoMusical eventoMusical;  // Instancia de la clase modelo

    public VentanaCancelacionEvento(EventoMusical eventoMusical) {
        this.eventoMusical = eventoMusical;
        initComponents();
    }

    private void initComponents() {
        nombreEventoLabel = new JLabel("Cancelar el evento: " + eventoMusical.getNombreEvento());
        cancelarEventoButton = new JButton("Cancelar Evento");

        cancelarEventoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar el evento, puedes llamar a métodos de la clase modelo (EventoMusical)
                eventoMusical.cancelarEvento();
                JOptionPane.showMessageDialog(VentanaCancelacionEvento.this, "Evento cancelado con éxito.");
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
                                        .addComponent(nombreEventoLabel)
                                        .addComponent(cancelarEventoButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(nombreEventoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelarEventoButton)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }
}
