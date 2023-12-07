package gui;// ... (imports y código existente)

import model.Entrada;
import model.EventoMusical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaVentaEntrada extends JFrame {
    private JComboBox<EventoMusical> eventosComboBox;
    private JComboBox<String> tipoEntradaComboBox;
    private JTextField precioTextField;
    private JTextField cantidadTextField;
    private JButton venderEntradaButton;

    public VentanaVentaEntrada(List<EventoMusical> eventos) {
        initComponents(eventos);
    }

    private void initComponents(List<EventoMusical> eventos) {
        eventosComboBox = new JComboBox<>(eventos.toArray(new EventoMusical[0]));
        tipoEntradaComboBox = new JComboBox<>(new String[]{"VIP", "General", "Otro"});
        precioTextField = new JTextField();
        cantidadTextField = new JTextField();
        venderEntradaButton = new JButton("Vender Entrada");

        venderEntradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Validación de entrada
                    EventoMusical eventoSeleccionado = (EventoMusical) eventosComboBox.getSelectedItem();
                    String tipoEntrada = (String) tipoEntradaComboBox.getSelectedItem();
                    double precio = Double.parseDouble(precioTextField.getText());
                    int cantidad = Integer.parseInt(cantidadTextField.getText());

                    // Validación de campos obligatorios
                    if (tipoEntrada.isEmpty() || cantidad <= 0 || precio <= 0) {
                        JOptionPane.showMessageDialog(VentanaVentaEntrada.this, "Por favor, complete todos los campos correctamente.");
                        return;
                    }

                    // Lógica para vender entrada
                    Entrada nuevaEntrada = new Entrada(tipoEntrada, precio, eventoSeleccionado);

                    // Puedes realizar más acciones según tus necesidades, como agregar la entrada al evento, etc.

                    JOptionPane.showMessageDialog(VentanaVentaEntrada.this, "Entrada vendida con éxito.");
                    // Puedes cerrar la ventana o realizar otras acciones según tus necesidades.
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaVentaEntrada.this, "Ingrese números válidos para Precio y Cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(VentanaVentaEntrada.this, "Error al vender entrada. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
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
                                        .addComponent(eventosComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tipoEntradaComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(precioTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cantidadTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(venderEntradaButton))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(eventosComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tipoEntradaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(precioTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(venderEntradaButton)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }
}
