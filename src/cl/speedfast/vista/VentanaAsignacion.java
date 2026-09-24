package cl.speedfast.vista;

import cl.speedfast.controller.DeliveryController;
import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.Pedido;
import cl.speedfast.model.Repartidor;

import javax.swing.*;
import java.awt.*;

public class VentanaAsignacion extends JFrame {
    private final DeliveryController controller;
    private JComboBox<Pedido> cmbPedidos;
    private JComboBox<Repartidor> cmbRepartidores;

    public VentanaAsignacion(DeliveryController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("SpeedFast - Asignar Repartidor / Iniciar Entrega");
        setSize(460, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Pedido Pendiente:"));
        cmbPedidos = new JComboBox<>();
        panel.add(cmbPedidos);

        panel.add(new JLabel("Repartidor:"));
        cmbRepartidores = new JComboBox<>();
        panel.add(cmbRepartidores);

        JButton btnIniciar = new JButton("Iniciar Entrega");
        JButton btnCerrar = new JButton("Cerrar");
        panel.add(btnIniciar);
        panel.add(btnCerrar);

        actualizarCombos();

        btnIniciar.addActionListener(e -> asignarEntrega());
        btnCerrar.addActionListener(e -> dispose());

        add(panel);
    }

    private void actualizarCombos() {
        cmbPedidos.removeAllItems();
        cmbRepartidores.removeAllItems();

        for (Pedido p : controller.getPedidosPendientes()) {
            cmbPedidos.addItem(p);
        }
        for (Repartidor r : controller.getListaRepartidores()) {
            cmbRepartidores.addItem(r);
        }
    }

    private void asignarEntrega() {
        Pedido pedidoSeleccionado = (Pedido) cmbPedidos.getSelectedItem();
        Repartidor repartidorSeleccionado = (Repartidor) cmbRepartidores.getSelectedItem();

        if (pedidoSeleccionado == null || repartidorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "No hay pedidos pendientes o repartidores disponibles.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Actualizar estado y asignación
        pedidoSeleccionado.setRepartidorAsignado(repartidorSeleccionado.getNombre());
        pedidoSeleccionado.setEstado(EstadoPedido.EN_REPARTO);

        JOptionPane.showMessageDialog(this,
                "Entrega iniciada:\nPedido #" + pedidoSeleccionado.getId() + " asignado a " + repartidorSeleccionado.getNombre(),
                "Entrega en Curso",
                JOptionPane.INFORMATION_MESSAGE);

        actualizarCombos();
    }
}