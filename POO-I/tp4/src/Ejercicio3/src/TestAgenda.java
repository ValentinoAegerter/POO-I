import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class TestAgenda {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Agregar eventos: uno pasado, uno futuro cercano, y otros
        Evento pasado = new Evento("Reunion pasada", LocalDateTime.of(2023, Month.JANUARY, 15, 10, 0), "Sala A");
        Evento futuroCercano = new Evento("Presentacion", LocalDateTime.now().plusDays(5).withHour(14).withMinute(30), "Auditorio");
        Evento futuroLejano = new Evento("Conferencia", LocalDateTime.of(2026, Month.DECEMBER, 1, 9, 0), "Centro Convenciones");
        Evento hoy = new Evento("Evento Hoy", LocalDateTime.now().withHour(16).withMinute(0), "Sala B");

        agenda.agregarEvento(pasado);
        agenda.agregarEvento(futuroCercano);
        agenda.agregarEvento(futuroLejano);
        agenda.agregarEvento(hoy);

        // Buscar evento existente
        agenda.buscarPorNombre("Presentacion").ifPresent(e -> System.out.println("Encontrado: " + e));

        // Buscar evento inexistente
        agenda.buscarPorNombre("NoExiste").ifPresentOrElse(
                e -> System.out.println("Encontrado: " + e),
                () -> System.out.println("Evento 'NoExiste' no encontrado")
        );

        // listar eventos proximos a partir de hoy
        LocalDate hoyFecha = LocalDate.now();
        List<Evento> proximos = agenda.eventosProximos(hoyFecha);
        System.out.println("Eventos proximos a partir de " + hoyFecha + ":");
        proximos.forEach(e -> System.out.println(" - " + e.nombre() + " (" + e.formatearFecha() + ")"));

        // Calcular y mostrar dias restantes/trasncurridos usando tiempoHastaEvento
        agenda.tiempoHastaEvento("Presentacion").ifPresent(s -> System.out.println("Presentacion: " + s));
        agenda.tiempoHastaEvento("Reunion pasada").ifPresent(s -> System.out.println("Reunion pasada: " + s));

        // Imprimir evento completo y su fecha formateada
        System.out.println("Evento completo: " + futuroLejano);
        System.out.println("Fecha formateada: " + futuroLejano.formatearFecha());

        // Intento de modificar un componente del record (no permitido):
        // futuroLejano.fecha = LocalDateTime.now(); // ERROR de compilacion: los componentes de record son finales e inmutables
    }
}
