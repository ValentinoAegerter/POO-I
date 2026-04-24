package Ejercicio2.src;
public class ConversorTemperatura {
    double convertir(double temperatura, String escalaOrigen,String escalaDestino){
        double celcius = switch (escalaOrigen.toUpperCase()){
            case "C" -> temperatura;
            case "F" -> (temperatura - 32) * 5.0 / 9.0;
            case "K" -> temperatura - 273.15;
            default -> Double.NaN;
        };

        if(Double.isNaN(celcius) || celcius < -273.15){
            return Double.NaN;
        }

        return switch(escalaDestino.toUpperCase()){
            case "C" -> celcius;
            case "F" -> (celcius * 9.0 / 5.0) + 32;
            case "K" -> celcius + 273.15;
            default -> (Double.NaN); 
        };
    };
    public static void main(String[] args) {
        ConversorTemperatura conversor = new ConversorTemperatura();

System.out.println("--- RESULTADOS DEL EJERCICIO ---");

        // 1. 0°C a Fahrenheit (Debe dar 32)
        System.out.println("0°C a Fahrenheit: " + conversor.convertir(0, "C", "F") + "°F");

        // 2. 100°C a Fahrenheit (Debe dar 212)
        System.out.println("100°C a Fahrenheit: " + conversor.convertir(100, "C", "F") + "°F");

        // 3. 32°F a Celsius (Debe dar 0)
        System.out.println("32°F a Celsius: " + conversor.convertir(32, "F", "C") + "°C");

        // 4. 0°C a Kelvin (Debe dar 273.15)
        System.out.println("0°C a Kelvin: " + conversor.convertir(0, "C", "K") + "K");

        // 5. Casos inválidos
        System.out.println("Escala incorrecta ('X'): " + conversor.convertir(20, "X", "C"));
        System.out.println("Temperatura imposible (-500K): " + conversor.convertir(-500, "K", "C"));
        
    }
}
