# SpeedFast - Sistema de Gestión de Entregas (Semana 6)

Aplicación de escritorio en Java desarrollada con Swing para la gestión y seguimiento de pedidos y despachos de la empresa SpeedFast.

---

## 📌 Descripción

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos II**. Implementa una interfaz gráfica de usuario (GUI) conectada con controladores y listas en memoria, permitiendo registrar pedidos, visualizarlos en tablas dinámicas y gestionar la asignación de entregas de forma interactiva.

---

## ⚙️ Funcionalidades

* **Ventana Principal:** Menú de navegación interactivo para acceder a los distintos módulos del sistema.
* **Registro de Pedidos:** Formulario con validación de campos obligatorios e ID numérico, además de selección de categoría mediante `JComboBox` (comida, encomienda, express).
* **Listado Dinámico:** Visualización tabular de los pedidos en tiempo real con `JTable` y `DefaultTableModel`.
* **Asignación y Despacho:** Módulo para asignar repartidores a pedidos y gestionar el flujo de entrega.
* **Manejo de Estados:** Control del ciclo de vida del pedido (`EstadoPedido`) y simulación logística con `ZonaDeCarga`.

---

## 📂 Estructura del Proyecto

```text
src/
 └── cl.speedfast/
      ├── controller/
      │    └── DeliveryController.java     # Lógica de negocio y gestión de datos en memoria
      ├── main/
      │    └── Main.java                   # Punto de entrada (lanza VentanaPrincipal)
      ├── model/
      │    ├── EstadoPedido.java           # Estados del ciclo del pedido
      │    ├── Pedido.java                 # Modelo de datos con sobrecarga de constructores
      │    ├── Repartidor.java             # Modelo de repartidores
      │    └── ZonaDeCarga.java            # Control de zonas de despacho
      └── vista/
           ├── VentanaPrincipal.java       # Menú principal y navegación
           ├── VentanaRegistroPedido.java  # Formulario de alta con validaciones
           ├── VentanaListaPedidos.java    # Tabla interactiva de pedidos
           └── VentanaAsignacion.java      # Interfaz de asignación y salida de pedidos
