/**
 * Implementación concreta de un rectángulo.
 * Implementa la capacidad de dibujar.
 */
public class Rectangulo extends Figura implements Dibujable {
    private double base;
    private double altura;

    /**
     * @param nombre nombre del rectángulo
     * @param base   base del rectángulo
     * @param altura altura del rectángulo
     */
    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando rectangulo: " + nombre);
    }

    @Override
    public String toString() {
        return super.toString() + ", base=" + base + ", altura=" + altura + ", area=" + String.format("%.4f", calcularArea());
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}
