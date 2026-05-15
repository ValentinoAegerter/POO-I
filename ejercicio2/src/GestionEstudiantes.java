import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private String nombre;
    private int legajo;
    private double promedio;

    public Estudiante(String nombre, int legajo, double promedio) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.promedio = promedio;
    }

    public String getNombre() { return nombre; }
    public int getLegajo() { return legajo; }
    public double getPromedio() { return promedio; }

    public boolean estaAprobado() {
        return promedio >= 6.0;
    }

    @Override
    public String toString() {
        return "Legajo: " + legajo + " | Nombre: " + nombre + " | Promedio: " + promedio;
    }
}

public class GestionEstudiantes {
    private List<Estudiante> estudiantes;

    public GestionEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void listarEstudiantes() {
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("[" + i + "] " + estudiantes.get(i));
        }
    }

    public Estudiante buscarPorLegajo(int legajo) {
        for (Estudiante e : estudiantes) {
            if (e.getLegajo() == legajo) {
                return e;
            }
        }
        return null;
    }

    public List<Estudiante> obtenerAprobados() {
        List<Estudiante> aprobados = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            if (e.estaAprobado()) {
                aprobados.add(e);
            }
        }
        return aprobados;
    }

    public Estudiante obtenerMejorEstudiante() {
        if (estudiantes.isEmpty()) return null;
        
        Estudiante mejor = estudiantes.get(0);
        for (Estudiante e : estudiantes) {
            if (e.getPromedio() > mejor.getPromedio()) {
                mejor = e;
            }
        }
        return mejor;
    }

    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;

        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.getPromedio();
        }
        return suma / estudiantes.size();
    }

    public static void main(String[] args) {
        GestionEstudiantes gestion = new GestionEstudiantes();
        
        gestion.agregarEstudiante(new Estudiante("Ana", 101, 8.5));
        gestion.agregarEstudiante(new Estudiante("Juan", 102, 5.0));
        gestion.agregarEstudiante(new Estudiante("Pedro", 103, 9.2));
        gestion.agregarEstudiante(new Estudiante("Lucia", 104, 7.0));
        gestion.agregarEstudiante(new Estudiante("Marcos", 105, 4.5));

        System.out.println("Todos los estudiantes:");
        gestion.listarEstudiantes();

        System.out.println("\nBuscar legajo 103:");
        System.out.println(gestion.buscarPorLegajo(103));
        System.out.println("Buscar legajo 999:");
        System.out.println(gestion.buscarPorLegajo(999));

        System.out.println("\nAprobados:");
        for (Estudiante e : gestion.obtenerAprobados()) {
            System.out.println(e);
        }

        System.out.println("\nMejor estudiante: " + gestion.obtenerMejorEstudiante());
        System.out.println("Promedio general: " + gestion.calcularPromedioGeneral());
    }
}