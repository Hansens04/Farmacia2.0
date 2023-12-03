import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> productos;
    private List<Proveedor> listaProveedores;

    public Proveedor(int id, String nombre, String direccion, String telefono, List<Proveedor> listaProveedores) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProveedores = (listaProveedores != null) ? new ArrayList<>(listaProveedores) : new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public List<Proveedor> getListaProveedores() {
        return new ArrayList<>(listaProveedores);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Error: El ID debe ser un número positivo.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void agregarProducto(String nombre, String descripcion, double precio) {
        String producto = "Nombre: " + nombre + ", Descripción: " + descripcion + ", Precio: " + precio;
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion +
                ", telefono=" + telefono + ", productos=" + productos + "]";
    }

    public void ingresarProveedor(Proveedor nuevoProveedor) {
        if (listaProveedores != null) {
            listaProveedores.add(nuevoProveedor);
        } else {
            throw new IllegalStateException("Error: La lista de proveedores no ha sido inicializada correctamente.");
        }
    }
}
