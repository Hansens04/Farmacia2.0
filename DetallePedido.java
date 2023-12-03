import java.util.ArrayList;
import java.util.List;

public class DetallePedido {
    private List<Producto> productos;
    private double total;

    public DetallePedido() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    public double getTotal() {
        return total;
    }

    private void calcularTotal() {
        total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DetallePedido [productos=");
        sb.append(productos);
        sb.append(", total=").append(total);
        sb.append("]");
        return sb.toString();
    }
}
