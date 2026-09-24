package cl.speedfast.model;

public class Pedido {
    private int id;
    private String direccionEntrega;
    private String tipo; // "comida", "encomienda", "express" requerido por la pauta
    private EstadoPedido estado;
    private String repartidorAsignado; // Para vincularlo con la asignación

    // Compatibilidad hacia atrás
    public Pedido(int id, String direccionEntrega) {
        this(id, direccionEntrega, "encomienda");
    }

    // Constructor con tipo (Semana 6)
    public Pedido(int id, String direccionEntrega, String tipo) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.tipo = tipo;
        this.estado = EstadoPedido.PENDIENTE;
        this.repartidorAsignado = "Sin asignar";
    }

    // Getters y Setters existentes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setEstado(String nuevoEstado) {
        try {
            this.estado = EstadoPedido.valueOf(nuevoEstado.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            System.err.println("Estado no válido: " + nuevoEstado);
        }
    }

    // Métodos de la interfaz gráfica
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " [" + tipo + "] - Destino: " + direccionEntrega + " (" + estado + ")";
    }
}