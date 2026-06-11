import java.time.LocalDate;
import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("ClienteA", LocalDate.now().minusDays(5), 150.0, EstadoPedido.PENDIENTE),
                new Pedido("ClienteB", LocalDate.now().minusDays(31), 200.0, EstadoPedido.ENVIADO),
                new Pedido("ClienteC", LocalDate.now().minusDays(10), 50.0, EstadoPedido.CANCELADO),
                new Pedido("ClienteA", LocalDate.now().minusDays(2), 300.0, EstadoPedido.ENTREGADO),
                new Pedido("ClienteD", LocalDate.of(2026, Month.JANUARY, 12), 75.0, EstadoPedido.PENDIENTE),
                new Pedido("ClienteE", LocalDate.now().minusDays(15), 120.0, EstadoPedido.ENVIADO),
                new Pedido("ClienteF", LocalDate.now().minusDays(3), 500.0, EstadoPedido.ENTREGADO),
                new Pedido("ClienteG", LocalDate.now().minusDays(40), 30.0, EstadoPedido.CANCELADO)
        );

        // 1. Pedidos pendientes recientes
        List<Pedido> pendientesRecientes = pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE)
                .filter(p -> p.getFecha().isAfter(LocalDate.now().minusDays(30)))
                .collect(Collectors.toList());
        System.out.println("Pedidos pendientes recientes:");
        pendientesRecientes.forEach(System.out::println);
        System.out.println();

        // 2. Clientes unicos ordenados
        List<String> clientesUnicos = pedidos.stream()
                .map(Pedido::getCliente)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Clientes unicos ordenados: " + clientesUnicos);
        System.out.println();

        // 3. Monto total y promedio por estado
        Map<EstadoPedido, DoubleSummaryStatistics> stats = pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getEstado, Collectors.summarizingDouble(Pedido::getTotal)));
        System.out.println("Monto total y promedio por estado:");
        stats.forEach((estado, ds) -> System.out.println(estado + " -> total=" + String.format("%.2f", ds.getSum()) + ", promedio=" + String.format("%.2f", ds.getAverage())));
        System.out.println();

        // 4. Pedido de mayor monto
        Optional<Pedido> mayor = pedidos.stream().max((a, b) -> Double.compare(a.getTotal(), b.getTotal()));
        mayor.ifPresentOrElse(
                p -> System.out.println("Mayor pedido: " + p),
                () -> System.out.println("No hay pedidos registrados")
        );

        // Verificacion con lista vacia y orElseThrow
        List<Pedido> vacio = List.of();
        try {
            Pedido p = vacio.stream().max((a, b) -> Double.compare(a.getTotal(), b.getTotal()))
                    .orElseThrow(() -> new RuntimeException("No hay pedidos en la lista vacia"));
            System.out.println(p);
        } catch (RuntimeException ex) {
            System.out.println("Excepcion esperada: " + ex.getMessage());
        }
        System.out.println();

        // 5. Nombres de clientes con pedidos cancelados
        String cancelados = pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.CANCELADO)
                .map(Pedido::getCliente)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Clientes con pedidos cancelados: " + cancelados);
    }
}
