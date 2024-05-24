
package ProblemaJava;

public class Problema01_Ejecutor {
   public static void main(String[] args) {
        // Crear algunos productos disponibles en la tienda
        Problema01_Producto producto1 = new Problema01_Producto("Laptop", 800, 5);
        Problema01_Producto producto2 = new Problema01_Producto("Mouse", 20, 50);
        Problema01_Producto producto3 = new Problema01_Producto("Teclado", 50, 30);

        // Crear carrito de compras
        Problema01_CarritoDeCompras carrito = new Problema01_CarritoDeCompras();

        // Agregar productos al carrito
        carrito.agregarProducto(producto1, 2);
        carrito.agregarProducto(producto2, 3);
        carrito.agregarProducto(producto3, 1);

        // Mostrar detalle de la compra
        carrito.mostrarDetalleCompra();

        // Calcular total
        double total = carrito.calcularTotal();
        System.out.println("Total a pagar: $" + total);

        // Realizar pago
        double montoPagado = 950;
        double descuentoPromocional = 0.1; // 10% de descuento si la compra supera $1000
        carrito.realizarPago(montoPagado, descuentoPromocional);

        // Mostrar detalle de la compra después del pago
        carrito.mostrarDetalleCompra();
    }
} 

