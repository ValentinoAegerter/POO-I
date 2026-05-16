package ejercicio2.src;

import java.util.Objects;

public class Empleado {

    private final String dni;
    private String nombre;
    private double sueldoBase;

    public Empleado(String nombre, String dni, double sueldoBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoBase = sueldoBase;
    }

    // Retorna el DNI (no puede sobreescribirse)
    public final String getDni() {
        return dni;
    }

    // Retorna el salario calculado (por ahora igual al sueldo base)
    public double calcularSalario() {
        return sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado[nombre=" + nombre + ", dni=" + dni + ", salario=" + calcularSalario() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false; // respetar simetría de tipos exactos
        Empleado other = (Empleado) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

}
