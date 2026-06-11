import java.util.Optional;

/**
 * Clase de prueba para el sistema de figuras geométricas.
 * Crea varias figuras, muestra información, usa instanceof para capacidades
 * y calcula el área total.
 */
public class TestFiguras {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[] {
            new Circulo("Circulo A", 2.5),
            new Rectangulo("Rectangulo B", 3.0, 4.0),
            new Circulo("Circulo C", 1.2)
        };

        double areaTotal = 0.0;

        for (Figura f : figuras) {
            // Imprimir información y área
            System.out.println(f.toString());
            System.out.println("Área: " + String.format("%.4f", f.calcularArea()));

            // Usar instanceof para capacidades
            if (f instanceof Dibujable) {
                ((Dibujable) f).dibujar();
            }
            if (f instanceof Coloreable) {
                ((Coloreable) f).colorear("rojo");
            }

            areaTotal += f.calcularArea();
            System.out.println();
        }

        System.out.println("Area total de todas las figuras: " + String.format("%.4f", areaTotal));

        // Intento de instanciar la clase abstracta Figura -> causa error de compilación
        // Figura f = new Figura("Generica");
        // La línea anterior está comentada porque Figura es abstracta y no se puede instanciar.

        // Comentarios breves sobre conceptos solicitados:
        // record: en Java, 'record' define una clase inmutable y concisa útil para DTOs.
        // Optional: java.util.Optional se usa para evitar nulls explícitos y expresar ausencia de valor.
        Optional<String> ejemplo = Optional.of("ejemplo");
        ejemplo.ifPresent(s -> System.out.println("Optional contiene: " + s));

        // Expresión lambda: usada arriba en ifPresent; son funciones anónimas concisas.
    }
}
