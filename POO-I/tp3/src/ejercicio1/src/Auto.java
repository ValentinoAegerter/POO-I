package ejercicio1.src;

public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int anio, int cantidadPuertas) {
        // 'super' llama al constructor de la superclase (Vehiculo) para inicializar sus atributos.
        super(marca, modelo, anio); 
        this.cantidadPuertas = cantidadPuertas;
    }

    // '@Override' asegura al compilador que estamos redefiniendo un método de la superclase.
    @Override
    public String toString() {
        // 'super.toString()' reutiliza el comportamiento de la clase padre.
        return super.toString() + ", puertas=" + cantidadPuertas;
    }
}