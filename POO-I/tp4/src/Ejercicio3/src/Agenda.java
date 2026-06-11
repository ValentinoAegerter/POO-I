import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase que mantiene una lista de eventos y provee operaciones de búsqueda y tiempo.
 */
public class Agenda {
    private List<Evento> eventos;

    public Agenda() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    /**
     * Busca el primer evento cuyo nombre coincida exactamente (ignorando mayúsculas/minúsculas).
     * @param nombre nombre a buscar
     * @return Optional con el evento o empty si no existe
     */
    public Optional<Evento> buscarPorNombre(String nombre) {
        return eventos.stream()
                .filter(e -> e.nombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    /**
     * Retorna los eventos cuya fecha (solo parte fecha) sea igual o posterior a 'hoy'.
     * @param hoy fecha de referencia (LocalDate)
     * @return lista de eventos proximos
     */
    public List<Evento> eventosProximos(LocalDate hoy) {
        return eventos.stream()
                .filter(e -> !e.fecha().toLocalDate().isBefore(hoy))
                .collect(Collectors.toList());
    }

    /**
     * Busca un evento por nombre y calcula el periodo entre hoy y la fecha del evento.
     * Retorna Optional con texto describiendo el tiempo o empty si no existe.
     * @param nombre nombre del evento
     * @return Optional con descripción del periodo
     */
    public Optional<String> tiempoHastaEvento(String nombre) {
        Optional<Evento> ev = buscarPorNombre(nombre);
        return ev.map(e -> {
            LocalDate hoy = LocalDate.now();
            LocalDate eventoFecha = e.fecha().toLocalDate();
            Period p = Period.between(hoy, eventoFecha);
            if (!eventoFecha.isBefore(hoy)) {
                return "Falta " + formatPeriod(p);
            } else {
                Period p2 = Period.between(eventoFecha, hoy);
                return "Evento pasado hace " + formatPeriod(p2);
            }
        });
    }

    private String formatPeriod(Period p) {
        // Use plain ASCII words to avoid encoding issues on Windows consoles
        StringBuilder sb = new StringBuilder();
        if (p.getYears() != 0) sb.append(p.getYears()).append(" anos ");
        if (p.getMonths() != 0) sb.append(p.getMonths()).append(" meses ");
        if (p.getDays() != 0) sb.append(p.getDays()).append(" dias");
        if (sb.isEmpty()) sb.append("0 dias");
        return sb.toString().trim();
    }
}
