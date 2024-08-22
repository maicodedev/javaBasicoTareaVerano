package org.tarea.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pedido {
    private String codigo;
    private LocalDate fechaPedido;
    private String nombreCliente;
    private String producto;
    private int unidades;
    private double precio;

    // Constructor
    public Pedido(String codigo, LocalDate fechaPedido, String nombreCliente, String producto, int unidades, double precio) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.nombreCliente = nombreCliente;
        this.producto = producto;
        this.unidades = unidades;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Método para calcular los días desde el pedido
    public long diasDesdePedido() {
        return ChronoUnit.DAYS.between(fechaPedido, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Código: %s, Fecha: %s, Cliente: %s, Producto: %s, Unidades: %d, Precio: %.2f",
                codigo, fechaPedido, nombreCliente, producto, unidades, precio);
    }
}
