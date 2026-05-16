package ejercicio2.src;

public class TestEmpleados {

    public static void main(String[] args) {
        Empleado[] arr = new Empleado[4];
        arr[0] = new Empleado("Ana", "11111111A", 3000);
        arr[1] = new EmpleadoTiempoCompleto("Luis", "22222222B", 3500, 12000);
        arr[2] = new EmpleadoPorHora("Marta", "33333333C", 2000, 20, 15.5);
        arr[3] = new EmpleadoTiempoCompleto("Carlos", "44444444D", 2800, 6000);

        for (Empleado e : arr) {
            System.out.println(e.toString());
            System.out.println("Salario calculado: " + e.calcularSalario());
            System.out.println();
        }

        Empleado e1 = new Empleado("Pepe", "55555555E", 2500);
        Empleado e2 = new Empleado("Jose", "55555555E", 2600);
        System.out.println("e1.equals(e2) ? " + e1.equals(e2)); // true

        Empleado etc = new EmpleadoTiempoCompleto("Igor", "66666666F", 3000, 1200);
        Empleado eph = new EmpleadoPorHora("Iggy", "66666666F", 3000, 10, 20);
        System.out.println("EmpleadoTiempoCompleto.equals(EmpleadoPorHora) ? " + etc.equals(eph)); // should be false due to getClass()
    }

}
