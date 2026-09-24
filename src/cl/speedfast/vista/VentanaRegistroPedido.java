package cl.speedfast.vista;

import cl.speedfast.controller.DeliveryController;
import cl.speedfast.model.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private final DeliveryController controller;
    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cmbTipo;

    public VentanaRegistroPedido(DeliveryController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("SpeedFast - Registro de Pedido");
        setSize(380, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("ID Pedido (número):"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panel.add(txtDireccion);

        panel.add(new JLabel("Tipo:"));
        cmbTipo = new JComboBox<>(new String[]{"comida", "encomienda", "express"});
        panel.add(cmbTipo);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        panel.add(btnGuardar);
        panel.add(btnCancelar);

        btnGuardar.addActionListener(e -> guardar());
        btnCancelar.addActionListener(e -> dispose());

        add(panel);
    }

    private void guardar() {
        String strId = txtId.getText().trim();
        String dir = txtDireccion.getText().trim();
        String tipo = (String) cmbTipo.getSelectedItem();

        // Validar campos vacíos
        if (strId.isEmpty() || dir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar ID numérico
        int id;
        try {
            id = Integer.parseInt(strId);
            if (id <= 0) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un número entero positivo.", "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un valor numérico entero (ej: 101).", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear objeto Pedido
        Pedido nuevo = new Pedido(id, dir, tipo);
        if (controller.agregarPedido(nuevo)) {
            JOptionPane.showMessageDialog(this, "Pedido registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            txtId.setText("");
            txtDireccion.setText("");
            cmbTipo.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "El ID ingresado (" + id + ") ya existe en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}