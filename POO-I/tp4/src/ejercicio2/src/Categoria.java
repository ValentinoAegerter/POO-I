/**
 * Enum que representa categorias de producto con su descuento asociado.
 */
public enum Categoria {
    ELECTRONICA(10.0),
    ROPA(20.0),
    ALIMENTOS(5.0);

    private final double descuento; // porcentaje

    Categoria(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}
