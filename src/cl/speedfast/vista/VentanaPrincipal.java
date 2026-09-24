package cl.speedfast.vista;

import cl.speedfast.controller.DeliveryController;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private final DeliveryController controller;

    public VentanaPrincipal() {
        this.controller = new DeliveryController();
        initUI();
    }

    private void initUI() {
        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblHeader = new JLabel("SpeedFast - Panel de Control", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 16));
        lblHeader.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));
        add(lblHeader, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));

        JButton btnRegistrar = new JButton("1. Registrar Pedido");
        JButton btnListar = new JButton("2. Listar Pedidos");
        JButton btnAsignar = new JButton("3. Asignar Repartidor / Iniciar Entrega");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);
        add(panelBotones, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido(controller).setVisible(true));
        btnListar.addActionListener(e -> new VentanaListaPedidos(controller).setVisible(true));
        btnAsignar.addActionListener(e -> new VentanaAsignacion(controller).setVisible(true));
    }
}