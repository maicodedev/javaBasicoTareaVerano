package org.tarea.controller;

import org.tarea.model.Pedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void modificarPedido(String codigo, LocalDate nuevaFecha, int nuevasUnidades) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo().equals(codigo)) {
                pedido.setFechaPedido(nuevaFecha);
                pedido.setUnidades(nuevasUnidades);
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }

    public void eliminarPedido(String codigo) {
        pedidos.removeIf(pedido -> pedido.getCodigo().equals(codigo));
    }

    public void mostrarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
            System.out.println("Días desde el pedido: " + pedido.diasDesdePedido());
        }
    }

    public static void main(String[] args) {
        PedidoController controller = new PedidoController();
        Scanner scanner = new Scanner(System.in);

        // Introducir 5 pedidos
        controller.agregarPedido(new Pedido("P001", LocalDate.of(2024, 6, 15), "Juan Pérez", "Laptop", 1, 1200.00));
        controller.agregarPedido(new Pedido("P002", LocalDate.of(2024, 6, 18), "Ana Gómez", "Teléfono", 2, 800.00));
        controller.agregarPedido(new Pedido("P003", LocalDate.of(2024, 7, 1), "Carlos Martínez", "Teclado", 3, 150.00));
        controller.agregarPedido(new Pedido("P004", LocalDate.of(2024, 7, 10), "Luisa Fernández", "Ratón", 1, 50.00));
        controller.agregarPedido(new Pedido("P005", LocalDate.of(2024, 7, 15), "Pedro Sánchez", "Monitor", 1, 300.00));

        // Mostrar pedidos
        controller.mostrarPedidos();

        // Modificar un pedido
        System.out.println("\nModificando pedido P003...");
        controller.modificarPedido("P003", LocalDate.of(2024, 7, 5), 5);

        // Mostrar pedidos después de la modificación
        controller.mostrarPedidos();

        // Eliminar un pedido
        System.out.println("\nEliminando pedido P004...");
        controller.eliminarPedido("P004");

        // Mostrar pedidos después de eliminar
        controller.mostrarPedidos();
    }
}
