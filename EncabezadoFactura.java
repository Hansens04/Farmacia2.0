import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EncabezadoFactura {
    private static int contadorFacturas = 100;

    private Cliente cliente;
    private int numeroFactura;
    private LocalDateTime fechaCompra;
    private List<DetalleFactura> detallesFactura;

    public EncabezadoFactura(Cliente cliente) {
        this.cliente = cliente;
        this.numeroFactura = generarNumeroFactura();
        this.fechaCompra = LocalDateTime.now();
        validarFecha();
        this.detallesFactura = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void agregarDetalleFactura(DetalleFactura detalleFactura) {
        detallesFactura.add(detalleFactura);
    }

    private int generarNumeroFactura() {
        return contadorFacturas++;
    }

    private void validarFecha() {
        if (!ValidadorFecha.esFechaValida(fechaCompra)) {
            throw new FechaInvalidaException("La fecha de compra no es válida: " + fechaCompra);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return "EncabezadoFactura{" +
                "cliente=" + cliente +
                ", numeroFactura=" + numeroFactura +
                ", fechaCompra=" + fechaCompra +
                '}';
    }

    // Excepción personalizada para fecha inválida
    public static class FechaInvalidaException extends RuntimeException {
        public FechaInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    // Supongamos que tienes una clase ValidadorFecha con un método estático esFechaValida
    public class ValidadorFecha {
        public static boolean esFechaValida(LocalDateTime fecha) {
            // Verificar si la fecha está en el pasado
            LocalDateTime fechaActual = LocalDateTime.now();
            return !fecha.isBefore(fechaActual);
        }
    }
}
