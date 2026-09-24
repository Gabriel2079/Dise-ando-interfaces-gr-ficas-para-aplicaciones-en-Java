package cl.speedfast.controller;

import cl.speedfast.model.Pedido;
import cl.speedfast.model.Repartidor;
import cl.speedfast.model.EstadoPedido;
import cl.speedfast.model.ZonaDeCarga;

import java.util.ArrayList;
import java.util.List;

public class DeliveryController {
    private final List<Pedido> listaPedidos;
    private final List<Repartidor> listaRepartidores;
    private final ZonaDeCarga zonaDeCarga;

    public DeliveryController() {
        this.listaPedidos = new ArrayList<>();
        this.listaRepartidores = new ArrayList<>();
        this.zonaDeCarga = new ZonaDeCarga();
        inicializarRepartidores();
    }

    private void inicializarRepartidores() {
        listaRepartidores.add(new Repartidor("Carlos Soto", zonaDeCarga));
        listaRepartidores.add(new Repartidor("Ana Valenzuela", zonaDeCarga));
        listaRepartidores.add(new Repartidor("Jorge Morales", zonaDeCarga));
    }

    public boolean agregarPedido(Pedido pedido) {
        for (Pedido p : listaPedidos) {
            if (p.getId() == pedido.getId()) {
                return false;
            }
        }
        listaPedidos.add(pedido);
        return true;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public List<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }

    public List<Pedido> getPedidosPendientes() {
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                pendientes.add(p);
            }
        }
        return pendientes;
    }


    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }
}