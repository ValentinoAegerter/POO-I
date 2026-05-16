package ejercicio1.src;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca , String modelo, int anio, int cilindrada){
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString(){
        return super.toString() + " Cilindrada: " + cilindrada + "cc";
    }
} 
