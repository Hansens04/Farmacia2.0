import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<String> cedulasUnicas = new ArrayList<>();
    private static List<String> telefonosUnicos = new ArrayList<>();

    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;
    private List<EncabezadoFactura> encabezadoFacturas = new ArrayList<>();

    public Cliente(String nombre, String cedula, String telefono, String direccion) {
        validarDatosEntrada(nombre, cedula, telefono);

        if (cedulasUnicas.contains(cedula)) {
            throw new CedulaDuplicadaException("La cédula ya existe. Debe ser única.");
        }

        if (telefonosUnicos.contains(telefono)) {
            throw new TelefonoDuplicadoException("El número de teléfono ya existe. Debe ser único.");
        }

        cedulasUnicas.add(cedula);
        telefonosUnicos.add(telefono);

        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void modificarCliente(String nuevoNombre, String nuevaCedula, String nuevoTelefono, String nuevaDireccion) {
        validarDatosEntrada(nuevoNombre, nuevaCedula, nuevoTelefono);

        if (!cedula.equals(nuevaCedula) && cedulasUnicas.contains(nuevaCedula)) {
            throw new CedulaDuplicadaException("La nueva cédula ya existe. Debe ser única.");
        }

        if (!telefono.equals(nuevoTelefono) && telefonosUnicos.contains(nuevoTelefono)) {
            throw new TelefonoDuplicadoException("El nuevo número de teléfono ya existe. Debe ser único.");
        }

        actualizarListasUnicas(cedula, nuevaCedula, telefono, nuevoTelefono);

        this.nombre = nuevoNombre;
        this.cedula = nuevaCedula;
        this.telefono = nuevoTelefono;
        this.direccion = nuevaDireccion;
    }

    private void actualizarListasUnicas(String cedulaAntigua, String cedulaNueva, String telefonoAntiguo, String telefonoNuevo) {
        cedulasUnicas.remove(cedulaAntigua);
        cedulasUnicas.add(cedulaNueva);

        telefonosUnicos.remove(telefonoAntiguo);
        telefonosUnicos.add(telefonoNuevo);
    }

    private void validarDatosEntrada(String nombre, String cedula, String telefono) {
        if (nombre == null || nombre.isEmpty() || cedula == null || cedula.isEmpty() || telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Los datos de entrada no pueden ser nulos o vacíos.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public static class CedulaDuplicadaException extends RuntimeException {
        public CedulaDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }

    public static class TelefonoDuplicadoException extends RuntimeException {
        public TelefonoDuplicadoException(String mensaje) {
            super(mensaje);
        }
    }

    // Otros métodos y clases relacionadas con EncabezadoFactura y cualquier otro código adicional.
}
