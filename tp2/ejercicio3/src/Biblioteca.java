import java.util.*;

public class Biblioteca {

    public static class Libro {
        private String isbn;
        private String titulo;
        private String autor;
        private Set<String> categorias;

        public Libro(String isbn, String titulo, String autor) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.categorias = new HashSet<>();
        }

        public String getIsbn() { return isbn; }
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        
        public Set<String> getCategorias() {
            return new HashSet<>(categorias); 
        }

        public void agregarCategoria(String categoria) {
            categorias.add(categoria);
        }

        public boolean perteneceACategoria(String categoria) {
            return categorias.contains(categoria);
        }

        @Override
        public String toString() {
            return titulo + " por " + autor + " (ISBN: " + isbn + ") - Categorias: " + categorias;
        }
    }

    private Map<String, Libro> librosPorIsbn;
    private Map<String, Set<String>> librosPorCategoria;
    private Set<String> isbnPrestados;

    public Biblioteca() {
        this.librosPorIsbn = new HashMap<>();
        this.librosPorCategoria = new HashMap<>();
        this.isbnPrestados = new HashSet<>();
    }

    public void registrarLibro(Libro libro) {
        if (librosPorIsbn.containsKey(libro.getIsbn())) {
            return;
        }
        
        librosPorIsbn.put(libro.getIsbn(), libro);

        for (String categoria : libro.getCategorias()) {
            librosPorCategoria.putIfAbsent(categoria, new HashSet<>());
            librosPorCategoria.get(categoria).add(libro.getIsbn());
        }
    }

    public Libro buscarPorIsbn(String isbn) {
        return librosPorIsbn.get(isbn);
    }

    public Set<String> obtenerCategorias() {
        return librosPorCategoria.keySet();
    }

    public Set<Libro> buscarPorCategoria(String categoria) {
        Set<Libro> resultado = new HashSet<>();
        Set<String> isbns = librosPorCategoria.getOrDefault(categoria, new HashSet<>());
        for (String isbn : isbns) {
            resultado.add(librosPorIsbn.get(isbn));
        }
        return resultado;
    }

    public boolean prestarLibro(String isbn) {
        if (!librosPorIsbn.containsKey(isbn) || isbnPrestados.contains(isbn)) {
            return false;
        }
        isbnPrestados.add(isbn);
        return true;
    }

    public boolean devolverLibro(String isbn) {
        return isbnPrestados.remove(isbn);
    }

    public Set<Libro> obtenerLibrosDisponibles() {
        Set<Libro> disponibles = new HashSet<>();
        for (Libro libro : librosPorIsbn.values()) {
            if (!isbnPrestados.contains(libro.getIsbn())) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public void listarTodos() {
        for (Libro libro : librosPorIsbn.values()) {
            String estado = isbnPrestados.contains(libro.getIsbn()) ? "[PRESTADO]" : "[DISPONIBLE]";
            System.out.println(estado + " " + libro);
        }
    }

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();

        Libro l1 = new Libro("111", "Java Básico", "Autor A");
        l1.agregarCategoria("Programación");
        l1.agregarCategoria("Tecnología");

        Libro l2 = new Libro("222", "Patrones de Diseño", "Autor B");
        l2.agregarCategoria("Programación");

        Libro l3 = new Libro("333", "El Aleph", "Borges");
        l3.agregarCategoria("Ficción");

        Libro l4 = new Libro("444", "Cien años de soledad", "García Márquez");
        l4.agregarCategoria("Ficción");

        biblio.registrarLibro(l1);
        biblio.registrarLibro(l2);
        biblio.registrarLibro(l3);
        biblio.registrarLibro(l4);

        System.out.println("Categorías existentes: " + biblio.obtenerCategorias());

        System.out.println("\nLibros de Programación:");
        for (Libro l : biblio.buscarPorCategoria("Programación")) {
            System.out.println(l.getTitulo());
        }

        System.out.println("\nPrestar libro 111: " + biblio.prestarLibro("111"));
        System.out.println("Intentar prestar 111 de nuevo: " + biblio.prestarLibro("111"));

        System.out.println("\nEstado de la biblioteca:");
        biblio.listarTodos();

        System.out.println("\nDevolviendo 111...");
        biblio.devolverLibro("111");
        biblio.listarTodos();
    }
}