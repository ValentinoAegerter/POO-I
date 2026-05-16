package ejercicio3.src;

public class Mamifero extends Animal {

    private int mesesGestacion;

    public Mamifero(String nombre, int mesesGestacion) {
        super(nombre);
        this.mesesGestacion = mesesGestacion;
        System.out.println("Construyendo Mamifero: mesesGestacion=" + mesesGestacion);
    }

    @Override
    public String hacerSonido() {
        return super.hacerSonido() + " (es un mamífero)";
    }

    @Override
    public String toString() {
        return super.toString() + ", gestacion=" + mesesGestacion + " meses";
    }

    public int getMesesGestacion() {
        return mesesGestacion;
    }

}
