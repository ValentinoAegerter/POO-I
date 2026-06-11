/**
 * Clase abstracta que representa una figura geométrica genérica.
 * Declara el contrato para calcular el área y guarda el nombre común de las figuras.
 */
public abstract class Figura {
    protected String nombre;

    /**
     * Constructor que asigna el nombre de la figura.
     * @param nombre nombre de la figura
     */
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Calcula el área de la figura. Implementado por subclases concretas.
     * @return área de la figura
     */
    public abstract double calcularArea();

    /**
     * Retorna una representación básica de la figura.
     * @return String en formato: Figura[nombre=...]
     */
    @Override
    public String toString() {
        return "Figura[nombre=" + nombre + "]";
    }

    /**
     * Getter para el nombre, usado por subclases si es necesario.
     * @return nombre de la figura
     */
    public String getNombre() {
        return nombre;
    }
}
