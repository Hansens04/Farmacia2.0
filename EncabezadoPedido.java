import java.util.Date;
import java.util.List;

public class EncabezadoPedido {
    private String estado;
    private Proveedor proveedor;
    private List<DetallePedido> detallePedidos;
    private Date fechaPedido;
    private int contadorPedidos;
    private int codigoPedido;
    private boolean estadoEnviado;

    public EncabezadoPedido(String estado, Proveedor proveedor, List<DetallePedido> detallePedidos) {
        this.estado = estado;
        this.proveedor = proveedor;
        this.detallePedidos = detallePedidos;
        this.fechaPedido = new Date();
        this.codigoPedido = generarCodigoPedidoUnico();
    }

    public String getEstado() {
        return estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    private int generarCodigoPedidoUnico() {
        return contadorPedidos++;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void actualizarEstadoEnviado(boolean estadoEnviado) {
        this.estadoEnviado = estadoEnviado;

        if (estadoEnviado) {
            System.out.println("El pedido #" + codigoPedido + " ha sido enviado. Se ha actualizado el stock satisfactoriamente.");
        }
    }

    @Override
    public String toString() {
        return "EncabezadoPedido [codigoPedido=" + codigoPedido + ", estado=" + estado +
                ", proveedor=" + proveedor + ", fechaPedido=" + fechaPedido +
                ", estadoEnviado=" + estadoEnviado + "]";
    }
}
