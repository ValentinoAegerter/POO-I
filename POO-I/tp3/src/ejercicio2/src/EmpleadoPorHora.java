package ejercicio2.src;

public class EmpleadoPorHora extends Empleado {

    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHora(String nombre, String dni, double sueldoBase, int horasTrabajadas, double valorHora) {
        super(nombre, dni, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (horasTrabajadas * valorHora);
    }

    @Override
    public String toString() {
        String s = super.toString();
        if (s.endsWith("]")) {
            return s.substring(0, s.length() - 1) + ", horas=" + horasTrabajadas + ", valorHora=" + valorHora + "]";
        }
        return s + ", horas=" + horasTrabajadas + ", valorHora=" + valorHora;
    }

}
