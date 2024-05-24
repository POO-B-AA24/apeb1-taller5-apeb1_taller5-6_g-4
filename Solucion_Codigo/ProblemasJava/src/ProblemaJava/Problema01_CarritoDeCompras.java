package ProblemaJava;

import java.util.ArrayList;

public class Problema01_CarritoDeCompras {

    private ArrayList<Problema01_Producto> productos;
    private double total;

    public Problema01_CarritoDeCompras() {
        productos = new ArrayList<>();
        total = 0;
    }

    public void agregarProducto(Problema01_Producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            Problema01_Producto productoEnCarrito = new Problema01_Producto(producto.getNombre(), producto.getPrecio(), cantidad);
            productos.add(productoEnCarrito);
            total += producto.getPrecio() * cantidad;
            producto.setCantidad(producto.getCantidad() - cantidad);
            System.out.println(cantidad + " unidades de " + producto.getNombre() + " agregadas al carrito.");
        } else {
            System.out.println("No hay suficiente cantidad disponible para " + producto.getNombre());
        }
    }

    public double calcularTotal() {
        return total;
    }

    public void realizarPago(double montoPagado, double descuentoPromocional) {
        double totalConDescuento = total > 1000 ? total * (1 - descuentoPromocional) : total;
        if (montoPagado >= totalConDescuento) {
            System.out.println("Pago realizado con éxito. ¡Gracias por su compra!");
            total = 0;
            productos.clear();
        } else {
            System.out.println("Monto insuficiente. Faltan $" + (totalConDescuento - montoPagado));
        }
    }

    public void mostrarDetalleCompra() {
        if (productos.isEmpty()) {
            System.out.println("El carrito de compras está vacío.");
        } else {
            System.out.println("Detalle de la compra:");
            for (Problema01_Producto producto : productos) {
                System.out.println(producto.toString());
            }
            System.out.println("Total: $" + total);
        }
    }
}
