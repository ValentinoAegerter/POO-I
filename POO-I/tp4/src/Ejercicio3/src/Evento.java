import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Registro inmutable que representa un evento en la agenda.
 * Componentes: nombre, fecha (LocalDateTime) y ubicacion.
 */
public record Evento(String nombre, LocalDateTime fecha, String ubicacion) {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * Retorna la fecha del evento formateada como "dd/MM/yyyy HH:mm".
     * @return fecha formateada
     */
    public String formatearFecha() {
        return fecha.format(FORMATO);
    }
}
