/**
 * Clase Producto con orden natural por precio base.
 */
public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public double calcularPrecioFinal() {
        return precio * (1 - categoria.getDescuento() / 100.0);
    }

    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return "Producto[nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + ", final=" + String.format("%.2f", calcularPrecioFinal()) + "]";
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public Categoria getCategoria() { return categoria; }
}
