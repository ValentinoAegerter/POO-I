package ejercicio1.src; 
class Vehiculo {
    protected String marca ;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca,String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;    
    }

    @Override
    public String toString() {
        return "Vehiculo [marca= " + marca + "modelo=" + modelo + "anio=" + anio + "]";
    }

    public final String obtenerDescripcionCorta(){
        return marca + " " + modelo;
    }
}
