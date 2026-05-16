package ejercicio2.src;

public class EmpleadoTiempoCompleto extends Empleado {

    private double bonoAnual;

    public EmpleadoTiempoCompleto(String nombre, String dni, double sueldoBase, double bonoAnual) {
        super(nombre, dni, sueldoBase);
        this.bonoAnual = bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoAnual / 12.0;
    }

    @Override
    public String toString() {
        String s = super.toString();
        if (s.endsWith("]")) {
            return s.substring(0, s.length() - 1) + ", bonoAnual=" + bonoAnual + "]";
        }
        return s + ", bonoAnual=" + bonoAnual;
    }

}
