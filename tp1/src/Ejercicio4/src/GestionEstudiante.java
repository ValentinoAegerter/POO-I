package Ejercicio4.src;
class Estudiante{
    private String nombre;
    private int legajo;
    private double promedio;

    public Estudiante(String nombre, int legajo, double promedio){
        this.nombre= nombre;
        this.legajo=legajo;
        this.promedio = promedio;
    }

    //Getters
    public String getNombre() {return nombre;}
    public int getLegajo() {return legajo;}
    public double getPromedio() {return promedio;}

    public boolean estaAprobado() {
        return this.promedio >= 6.0;
    }


@Override
    public String toString() {
        return String.format("Nombre: %-10s | Legajo: %-5d | Promedio: %-4.1f | Estado: %s", 
                nombre, legajo, promedio, (estaAprobado() ? "APROBADO" : "DESAPROBADO"));
    }
}

public class GestionEstudiante {
    private Estudiante[] estudiantes;
    private int cantidad;

    public GestionEstudiante(){
        this.estudiantes = new Estudiante [5];
        this.cantidad = 0;
    }


public boolean agregarEstudiante (String nombre, int legajo, double promedio){
    if(cantidad < estudiantes.length) {
        estudiantes[cantidad] = new Estudiante(nombre, legajo, promedio);
        cantidad++;
        return true;
        }
    return false;
    }


public void listarEstudiantes(){
    System.out.println("Lista de estudiantes");
    for (int i=0 ; i < cantidad; i++) {
        System.out.println(i + "." + estudiantes[i].toString());
        }
    }

public Estudiante buscarPorLegajo (int legajo){
    for(int i=0 ; i < cantidad; i++){
        if (estudiantes[i].getLegajo() == legajo){
            return estudiantes[i];
            }
        }
        return null;
    }

    public double calcularPromedioGeneral(){
        if(cantidad == 0) return 0.0;
        double suma = 0;
        for(int i=0 ; i < cantidad; i++){
            suma += estudiantes[i].getPromedio();
        }
        return suma / cantidad;
    } 
    
    public int obtenerAprobados(){
        int contadorAp = 0 ;
        for (int i = 0; i < cantidad; i++){
            if(estudiantes[i].estaAprobado()){
                contadorAp ++;
            }
        }
        return contadorAp;
    }

    public Estudiante obtenerMejorEstudiante(){
        if (cantidad == 0) return null;
        Estudiante  mejor = estudiantes[0];
        for (int i = 0; i < cantidad; i++){
            if(estudiantes[i].getPromedio() > mejor.getPromedio()){
                mejor = estudiantes[i];
            }
        }
        return mejor;
    }

    public static void main(String[] args) {
        GestionEstudiante gestion = new GestionEstudiante();

        // Agregar estudiantes
        gestion.agregarEstudiante("Ana", 101, 8.5);
        gestion.agregarEstudiante("Pedro", 102, 4.0);
        gestion.agregarEstudiante("Lucía", 103, 7.2);
        gestion.agregarEstudiante("Juan", 104, 5.5);
        gestion.agregarEstudiante("Marta", 105, 9.0);

        // Limite de estudiantes 
        boolean agregado = gestion.agregarEstudiante("Extra", 106, 10.0);
        System.out.println("¿Se pudo agregar el sexto estudiante?: " + agregado);

        // 2. Listar
        gestion.listarEstudiantes();

        // 3. Búsqueda
        System.out.println("\nBuscando legajo 103...");
        Estudiante e = gestion.buscarPorLegajo(103);
        System.out.println(e != null ? "Encontrado: " + e.getNombre() : "No encontrado");

        // 4. Estadísticas
        System.out.println("\nPromedio General: " + gestion.calcularPromedioGeneral());
        System.out.println("Cantidad de Aprobados: " + gestion.obtenerAprobados());
        
        Estudiante mejor = gestion.obtenerMejorEstudiante();
        System.out.println("Mejor Estudiante: " + (mejor != null ? mejor.getNombre() : "N/A"));
    }
}