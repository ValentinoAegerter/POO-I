public class Calculadora {

    // Definición de una constante para PI (opcional si se usa Math.PI)
    private static final double PI = 3.141592653589793;

    // 1. Sumar dos enteros
    public static int sumar(int a, int b) {
        return a + b;
    }

    // 2. Restar dos enteros
    public static int restar(int a, int b) {
        return a - b;
    }

    // 3. Multiplicar dos enteros
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    // 4. Dividir dos doubles con manejo de división por cero
    public static double dividir(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return a / b;
    }

    // 5. Calcular el área de un círculo: $$Area = \pi \times radio^2$$
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // 6. Calcular Factorial: $$n! = n \times (n-1) \times ... \times 1$$
    public static long calcularFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Método main para probar las operaciones
    public static void main(String[] args) {
        System.out.println("--- Pruebas de la Calculadora ---");

        // Casos Normales
        System.out.println("Suma (5 + 3): " + sumar(5, 3));
        System.out.println("Resta (10 - 4): " + restar(10, 4));
        System.out.println("Multiplicación (6 * 7): " + multiplicar(6, 7));
        System.out.println("División (10 / 2): " + dividir(10.0, 2.0));
        System.out.println("Área Círculo (radio 5): " + calcularAreaCirculo(5));
        System.out.println("Factorial (5!): " + calcularFactorial(5));

        System.out.println("\n--- Casos Especiales ---");

        // División por cero
        System.out.println("División por cero (10 / 0): " + dividir(10.0, 0.0));

        // Factorial de 0
        System.out.println("Factorial de 0: " + calcularFactorial(0));

        // Factorial de número negativo
        System.out.println("Factorial de -5: " + calcularFactorial(-5));
    }
}