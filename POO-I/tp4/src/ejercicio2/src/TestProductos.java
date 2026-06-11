import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestProductos {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Telefono", 500.0, Categoria.ELECTRONICA));
        productos.add(new Producto("Remera", 25.0, Categoria.ROPA));
        productos.add(new Producto("Laptop", 1200.0, Categoria.ELECTRONICA));
        productos.add(new Producto("Pan", 2.5, Categoria.ALIMENTOS));
        productos.add(new Producto("Pantalon", 60.0, Categoria.ROPA));
        productos.add(new Producto("Queso", 8.0, Categoria.ALIMENTOS));

        // Orden natural por precio base
        Collections.sort(productos);
        System.out.println("Orden natural por precio base:");
        productos.forEach(System.out::println);
        System.out.println();

        // Ordenar por nombre alfabetico usando lambda
        productos.sort(Comparator.comparing(p -> p.getNombre()));
        System.out.println("Orden por nombre alfabetico:");
        productos.forEach(System.out::println);
        System.out.println();

        // Ordenar por categoria y luego por precio final descendente
        Comparator<Producto> cmp = Comparator.comparing(Producto::getCategoria)
                .thenComparing(Comparator.comparingDouble(Producto::calcularPrecioFinal)).reversed();
        productos.sort(cmp);
        System.out.println("Orden por categoria y precio final descendente:");
        productos.forEach(System.out::println);
        System.out.println();

        // Buscar producto con precio final mas bajo
        Optional<Producto> minFinal = productos.stream().min(Comparator.comparingDouble(Producto::calcularPrecioFinal));
        minFinal.ifPresentOrElse(
                p -> System.out.println("Producto con precio final mas bajo: " + p),
                () -> System.out.println("No hay productos")
        );
    }
}
