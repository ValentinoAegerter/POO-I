package ejercicio1.src;

public class TestVehiculos {
    public static void main(String[] args) {
        Auto miAuto = new Auto("Toyota", "Corolla", 2023, 4);
        Moto miMoto = new Moto("Yamaha", "MT-07", 2022, 689);

        // Imprime usando el toString() sobreescrito, que a su vez usa super.toString()
        System.out.println(miAuto);
        System.out.println(miMoto);

        // Verifica que obtenerDescripcionCorta() heredado funciona correctamente
        System.out.println("Descripción Auto: " + miAuto.obtenerDescripcionCorta());
        System.out.println("Descripción Moto: " + miMoto.obtenerDescripcionCorta());

        /* * Intento de sobreescritura (daría error de compilación):
         * public class Auto extends Vehiculo {
         * @Override
         * public String obtenerDescripcionCorta() { // ERROR: no se puede sobreescribir un método final
         * return "Auto: " + marca;
         * }
         * }
         */
    }
}
