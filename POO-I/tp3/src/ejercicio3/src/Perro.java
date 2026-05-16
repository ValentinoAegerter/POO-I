package ejercicio3.src;

public class Perro extends Mamifero {

    private String raza;

    public Perro(String nombre, int mesesGestacion, String raza) {
        super(nombre, mesesGestacion);
        this.raza = raza;
        System.out.println("Construyendo Perro: raza=" + raza);
    }

    @Override
    public String hacerSonido() {
        return "Guau! (sobreescribe completamente el sonido)";
    }

    @Override
    public String toString() {
        return super.toString() + ", raza=" + raza;
    }

}
