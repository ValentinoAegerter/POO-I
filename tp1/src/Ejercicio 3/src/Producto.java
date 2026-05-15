public class Producto {
    // Atributos privados (Encapsulamiento)
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor con validaciones
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        
        // Si el precio es negativo, asignar 0
        if (precio < 0) {
            this.precio = 0;
        } else {
            this.precio = precio;
        }

        // Si el stock es negativo, asignar 0
        if (stock < 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    // --- Métodos de Acceso (Getters y Setters) ---

    public String getCodigo() { return codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    // --- Métodos de Negocio ---

    // Retorna: $$precio \times stock$$
    public double calcularValorInventario() {
        return this.precio * this.stock;
    }

    public boolean descontarStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            double descuento = this.precio * (porcentaje / 100);
            this.precio -= descuento;
        }
    }

    @Override
    public String toString() {
        return "Producto [" +
               "Código: " + codigo + 
               " | Nombre: " + nombre + 
               " | Precio: $" + precio + 
               " | Stock: " + stock + "]";
    }

    // --- Método Main para Pruebas ---
    public static void main(String[] args) {
        System.out.println("--- Creando productos ---");
        
        // 1. Producto con valores válidos
        Producto p1 = new Producto("A100", "Notebook Pro", 1500.0, 10);
        
        // 2. Producto con valores negativos (prueba de constructor)
        Producto p2 = new Producto("B200", "Mouse Gamer", -500.0, -5);

        System.out.println("P1: " + p1.toString());
        System.out.println("P2 (debe tener 0 en precio y stock): " + p2.toString());

        System.out.println("\n--- Probando Setters ---");
        p1.setPrecio(-100); // No debería cambiar
        p1.setStock(20);    // Debería cambiar
        System.out.println("P1 tras intentar precio -100 y stock 20: " + p1.toString());

        System.out.println("\n--- Probando Negocio ---");
        System.out.println("Valor inventario P1: $" + p1.calcularValorInventario());

        // Descontar stock
        System.out.println("Descontar 5 de P1: " + p1.descontarStock(5));
        System.out.println("Descontar 50 de P1 (insuficiente): " + p1.descontarStock(50));

        // Aplicar descuento
        p1.aplicarDescuento(10); // 10% de 1500 es 150 -> queda 1350
        System.out.println("P1 tras descuento del 10%: " + p1.toString());
    }
}