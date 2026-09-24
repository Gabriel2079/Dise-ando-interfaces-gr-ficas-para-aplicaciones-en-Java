package cl.speedfast.vista;

import cl.speedfast.controller.DeliveryController;
import cl.speedfast.model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {
    private final DeliveryController controller;
    private DefaultTableModel model;

    public VentanaListaPedidos(DeliveryController controller) {
        this.controller = controller;
        initUI();
        cargarDatos();
    }

    private void initUI() {
        setTitle("SpeedFast - Listado de Pedidos");
        setSize(650, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        // Columnas incluyendo el repartidor asignado
        String[] columnas = {"ID", "Dirección", "Tipo", "Estado", "Repartidor"};
        model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRefrescar = new JButton("Refrescar");
        JButton btnCerrar = new JButton("Cerrar");

        btnRefrescar.addActionListener(e -> cargarDatos());
        btnCerrar.addActionListener(e -> dispose());

        panelSur.add(btnRefrescar);
        panelSur.add(btnCerrar);
        add(panelSur, BorderLayout.SOUTH);
    }

    public void cargarDatos() {
        model.setRowCount(0);
        for (Pedido p : controller.getListaPedidos()) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getDireccionEntrega(), // Corregido: método exacto de Pedido
                    p.getTipo(),
                    p.getEstado(),
                    p.getRepartidorAsignado() != null ? p.getRepartidorAsignado() : "Sin asignar"
            });
        }
    }
}