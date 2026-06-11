/**
 * Implementación concreta de una figura de tipo círculo.
 * Implementa las capacidades de dibujar y colorear.
 */
public class Circulo extends Figura implements Dibujable, Coloreable {
    private double radio;

    /**
     * @param nombre nombre del círculo
     * @param radio  radio del círculo (en unidades)
     */
    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando circulo: " + nombre);
    }

    @Override
    public void colorear(String color) {
        System.out.println("Coloreando circulo de color " + color);
    }

    @Override
    public String toString() {
        return super.toString() + ", radio=" + radio + ", area=" + String.format("%.4f", calcularArea());
    }

    public double getRadio() {
        return radio;
    }
}
