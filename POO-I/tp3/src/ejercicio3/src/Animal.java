package ejercicio3.src;

public class Animal {

    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
        System.out.println("Construyendo Animal: nombre=" + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String hacerSonido() {
        return "Sonido genérico de animal";
    }

    @Override
    public String toString() {
        return "Animal[nombre=" + nombre + "]";
    }

}
