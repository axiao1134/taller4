// Clase VentanaRegistroAsistente
package gui;

import model.Asistente;
import model.Entrada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistroAsistente extends JFrame {
    private JTextField nombreTextField;
    private JTextField informacionContactoTextField;
    private JButton registrarAsistenteButton;

    private List<Entrada> entradasCompradas;

    public VentanaRegistroAsistente() {
        initComponents();
        entradasCompradas = new ArrayList<>();
    }

    private void initComponents() {
        nombreTextField = new JTextField();
        informacionContactoTextField = new JTextField();
        registrarAsistenteButton = new JButton("Registrar Asistente");

        registrarAsistenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar asistente, puedes crear una instancia de la clase modelo (Asistente)
                // y llenarla con los datos ingresados en los campos de texto.
                String nombre = nombreTextField.getText();
                String informacionContacto = informacionContactoTextField.getText();

                // Validación de campos
                if (nombre.isEmpty() || informacionContacto.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaRegistroAsistente.this, "Por favor, complete todos los campos.");
                    return;
                }

                Asistente nuevoAsistente = new Asistente(nombre, informacionContacto);

                // Puedes manejar las preferencias musicales de alguna manera según tus necesidades.

                // Puedes realizar más acciones según tus necesidades, como agregar el asistente a una lista, etc.

                JOptionPane.showMessageDialog(VentanaRegistroAsistente.this, "Asistente registrado con éxito.");
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
                                        .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informacionContactoTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registrarAsistenteButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(informacionContactoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(registrarAsistenteButton)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }
}
