import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Contabilidad {
    private List<EncabezadoPedido> pedidos;
    private List<EncabezadoFactura> facturas;

    public Contabilidad() {
        this.pedidos = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void darPedido(EncabezadoPedido pedido) {
        pedidos.add(pedido);
    }

    public void darFactura(EncabezadoFactura factura) {
        facturas.add(factura);
    }

    private double calcularTotalMensuales(List<?> elementos, String tipo) {
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1;
        double totalMensuales = 0.0;

        for (Object elemento : elementos) {
            int mesElemento = obtenerMes(elemento);

            if (mesElemento == mesActual) {
                totalMensuales += obtenerTotal(elemento, tipo);
            }
        }

        return totalMensuales;
    }

    private int obtenerMes(Object elemento) {
        if (elemento instanceof EncabezadoFactura factura) {
            Calendar fechaFactura = new GregorianCalendar(
                    factura.getFechaCompra().darAnio(),
                    factura.getFechaCompra().darMes() - 1,
                    factura.getFechaCompra().darDia()
            );
            return fechaFactura.get(Calendar.MONTH) + 1;
        } else if (elemento instanceof EncabezadoPedido) {
            EncabezadoPedido pedido = (EncabezadoPedido) elemento;
            Calendar fechaPedido = new GregorianCalendar(
                    pedido.getFechaPedido().darAnio(),
                    pedido.getFechaPedido().darMes() - 1,
                    pedido.getFechaPedido().darDia()
            );
            return fechaPedido.get(Calendar.MONTH) + 1;
        } else {
            // Manejo de error, por ejemplo, lanzar una excepción o devolver un valor predeterminado
            throw new IllegalArgumentException("Tipo de elemento no compatible");
        }
    }

    private double obtenerTotal(Object elemento, String tipo) {
        double total = 0.0;

        if ("ingresos".equals(tipo) && elemento instanceof EncabezadoFactura) {
            EncabezadoFactura factura = (EncabezadoFactura) elemento;
            total = factura.getDetalleFactura().getTotal();
        } else if ("egresos".equals(tipo) && elemento instanceof EncabezadoPedido) {
            EncabezadoPedido pedido = (EncabezadoPedido) elemento;
            total = pedido.getDetallePedido().calcularTotal();
        } else {
            // Manejo de error, por ejemplo, lanzar una excepción o devolver un valor predeterminado
            throw new IllegalArgumentException("Tipo de elemento o acción no compatible");
        }

        return total;
    }

    public double calcularIngresosMensuales() {
        return calcularTotalMensuales(facturas, "ingresos");
    }

    public double calcularEgresosMensuales() {
        return calcularTotalMensuales(pedidos, "egresos");
    }

    public double getTotal() {
        return calcularIngresosMensuales() - calcularEgresosMensuales();
    }

    public void visualizarPatrimonio() {
        double ingresosMensuales = calcularIngresosMensuales();
        double egresosMensuales = calcularEgresosMensuales();
        double patrimonio = ingresosMensuales - egresosMensuales;

        if (patrimonio > 0) {
            System.out.println("Superávit: " + patrimonio);
        } else if (patrimonio < 0) {
            System.out.println("Déficit: " + patrimonio);
        } else {
            System.out.println("Equilibrio: " + patrimonio);
        }
    }

    public void visualizarIngresos() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1;

        System.out.println("Facturas del mes:");

        for (EncabezadoFactura factura : facturas) {
            Fecha fechaFactura = factura.getFechaCompra();

            if (fechaFactura.darMes() == mesActual) {
                System.out.println("Fecha: " + dateFormat.format(fechaFactura) + " - Total: " + factura.getDetalleFactura().getTotal());
            }
        }
    }


    public void visualizarEgresos() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        int mesActual = calendar.get(Calendar.MONTH) + 1;

        System.out.println("Pedidos del mes:");

        for (EncabezadoPedido pedido : pedidos) {
            Fecha fechaPedido = pedido.getFechaPedido();

            if (fechaPedido.darMes() == mesActual) {
                System.out.println("Fecha: " + dateFormat.format(fechaPedido) + " - Total: " + pedido.getDetallePedido().calcularTotal());
            }
        }
    }

}
