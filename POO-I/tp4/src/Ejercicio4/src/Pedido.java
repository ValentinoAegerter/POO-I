import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Clase Pedido con atributos cliente, fecha, total y estado.
 */
public class Pedido {
    private String cliente;
    private LocalDate fecha;
    private double total;
    private EstadoPedido estado;

    public Pedido(String cliente, LocalDate fecha, double total, EstadoPedido estado) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaStr = fecha.format(fmt);
        return "Pedido[cliente=" + cliente + ", fecha=" + fechaStr + ", total=" + String.format(Locale.US, "%.2f", total) + ", estado=" + estado + "]";
    }

    public String getCliente() { return cliente; }
    public LocalDate getFecha() { return fecha; }
    public double getTotal() { return total; }
    public EstadoPedido getEstado() { return estado; }
}
