import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Producto {
    private static List<Producto> listaProductos = new ArrayList<>();

    private String codigoProducto;
    private String nombre;
    private int stockActual;
    private int cantidadMinima;
    private double precio;
    private String descripcion;

    public Producto(String codigoProducto, String nombre, int stockActual, int cantidadMinima, double precio, String descripcion) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.cantidadMinima = cantidadMinima;
        this.precio = precio;
        this.descripcion = descripcion;
        listaProductos.add(this);
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static List<Producto> getListaProductos() {
        return Collections.unmodifiableList(listaProductos);
    }

    public static void ingresarProducto(Producto nuevoProducto) {
        if (!listaProductos.contains(nuevoProducto)) {
            listaProductos.add(nuevoProducto);
        }
    }

    public static void modificarProducto(Producto productoExistente, Producto nuevoProducto) {
        if (listaProductos.contains(productoExistente)) {
            int index = listaProductos.indexOf(productoExistente);
            listaProductos.set(index, new Producto(
                    nuevoProducto.getCodigoProducto(),
                    nuevoProducto.getNombre(),
                    nuevoProducto.getStockActual(),
                    nuevoProducto.getCantidadMinima(),
                    nuevoProducto.getPrecio(),
                    nuevoProducto.getDescripcion()
            ));
        } else {
            throw new IllegalArgumentException("Error: El producto no existe en la lista.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigoProducto.equals(producto.codigoProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProducto);
    }

    @Override
    public String toString() {
        return "Producto [codigoProducto=" + codigoProducto + ", nombre=" + nombre +
                ", stockActual=" + stockActual + ", cantidadMinima=" + cantidadMinima +
                ", precio=" + precio + ", descripcion=" + descripcion + "]";
    }
}
